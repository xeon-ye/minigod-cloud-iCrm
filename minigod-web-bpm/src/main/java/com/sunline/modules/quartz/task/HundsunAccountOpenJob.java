package com.sunline.modules.quartz.task;

import com.alibaba.fastjson.JSON;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.entity.*;
import com.sunline.modules.account.online.service.*;
import com.sunline.modules.account.online.service.impl.HundsunOpenAccountService;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.app.service.ApiUserService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @description: 恒生后台开户调度任务
 * @author: Larry Lai
 * @date: 2018/10/11 16:18
 * @version: v1.0
 */

@Component("hundsunAccountOpenJob")
//@DisallowConcurrentExecution
public class HundsunAccountOpenJob {

    private static final Logger logger = LoggerFactory.getLogger(HundsunAccountOpenJob.class);

    @Autowired
    HundsunOpenAccountService hundsunOpenAccountService;
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    CustomerAccMarginOpenApplyService customerAccMarginOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    ApiUserService userApiService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    AyersAccOpenService ayersAccOpenService;

    /**
     * ayers柜台导入数据
     *
     * @param params
     */
    public void excute(String params) {

        logger.info(params + "任务开始");

        //正常开户
        List<CustomerAccountOpenApplyEntity> waitingForAccountOpenData = getWaitingForAccountOpenData();
        logger.info("互联网后台开户开始，待开户数据条数：" + waitingForAccountOpenData.size());
        doArrangeData(waitingForAccountOpenData);

        //增开
        List<CustomerAccountMarginOpenApplyEntity> waitingForAccountMarginOpenData = getWaitingForAccountMarginOpenData();
        logger.info("增开后台开户开始，待开户数据条数：" + waitingForAccountMarginOpenData.size());
        doArrangeMarginData(waitingForAccountMarginOpenData);
    }

    /**
     * 获取待开户申请列表
     * 正常开户
     *
     * @return
     */
    private List<CustomerAccountOpenApplyEntity> getWaitingForAccountOpenData() {
        CustomerAccountOpenApplyEntity queryCondition = new CustomerAccountOpenApplyEntity();
        queryCondition.setCurrentNode("开户");
        return customerAccOpenApplyService.queryListByBean(queryCondition);
    }

    /**
     * 获取待开户申请列表
     * 增开
     *
     * @return
     */
    private List<CustomerAccountMarginOpenApplyEntity> getWaitingForAccountMarginOpenData() {
        CustomerAccountMarginOpenApplyEntity queryCondition = new CustomerAccountMarginOpenApplyEntity();
        queryCondition.setCurrentNode("开户");
        return customerAccMarginOpenApplyService.queryListByBean(queryCondition);
    }

    /**
     * 数据归档
     * 正常开户
     *
     * @param openAcctList
     */
    private void doArrangeData(List<CustomerAccountOpenApplyEntity> openAcctList) {
        for (CustomerAccountOpenApplyEntity openApplicationEntity : openAcctList) {
            int count = 0;
            CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = customerAccountOpenInfoService.queryByApplicationId(openApplicationEntity.getApplicationId());
            AyersClientInfoEntity clientInfoEntity = ayersAccOpenService.createClientInfoEntity(customerAccountOpenInfoEntity);
            count = ayersAccOpenService.saveClientInfo(clientInfoEntity);
            if (count > 0) {
                AyersClientAccEntity clientAccEntity = ayersAccOpenService.createClientAccEntity(customerAccountOpenInfoEntity);
                count = ayersAccOpenService.saveClineAcc(clientAccEntity);
            }

            if (count > 0) {
                // 数据归档
                SecuritiesUserModel securitiesUserModel = CustomerOpenAccountConverter.converterToSecuritiesUserInfo(customerAccountOpenInfoEntity);
                ResponseVO responseVO = securitiesUserInfoService.addSecuritiesUserInfo(securitiesUserModel);
                logger.info("同步开户数据至统一用户中心结果：" + JSON.toJSONString(responseVO));

                // 驱动流程下一步
                actModelerService.doNextFlow(openApplicationEntity.getApplicationId(), openApplicationEntity.getInstanceId(), "");

                // 互联网开户需要备份影像资料
                if (1 == customerAccountOpenInfoEntity.getOpenAccountType()) {
                    customerAccountOpenService.backupAccountOpenImage(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());
                    customerAccountOpenService.backupAccountOpenReport(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());
                }

                // 备份AML文件
                customerAccountOpenService.backupAccountOpenAml(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());

                // 归档节点程序自动审核
                CustomerAccountOpenApplyEntity customerAccountOpenApplyEntity = customerAccOpenApplyService.queryObjectByApplicationId(openApplicationEntity.getApplicationId());
                CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(openApplicationEntity.getApplicationId());

                if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "5").equals(customerAccountOpenApplyEntity.getCurrentNode())) {

                    // CA认证更新开户状态为已开户，帐户等级为标准帐户
                    //线下开户等级为标准账户
                    if (1 == customerAccountOpenInfo.getBankType() || 2 == customerAccountOpenInfo.getOpenAccountType()) {
                        // 更新预约申请表相关信息
                        CustomerAccountOpenApplyEntity customerAccOpenApply = new CustomerAccountOpenApplyEntity();
                        customerAccOpenApply.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                        customerAccOpenApply.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE);

                        customerAccOpenApplyService.updateByApplicationId(customerAccOpenApply);

                        // 更新账户等级
                        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity1 = new CustomerAccountOpenInfoEntity();
                        customerAccountOpenInfoEntity1.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                        customerAccountOpenInfoEntity1.setAccountLevel(3);
                        customerAccountOpenInfoService.update(customerAccountOpenInfoEntity1);
                    } else {
                        // 更新账户等级为预批帐户
                        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity2 = new CustomerAccountOpenInfoEntity();
                        customerAccountOpenInfoEntity2.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                        customerAccountOpenInfoEntity2.setAccountLevel(1);
                        customerAccountOpenInfoService.update(customerAccountOpenInfoEntity2);
                    }

                    actModelerService.doNextFlow(openApplicationEntity.getApplicationId(), openApplicationEntity.getInstanceId(), "");
                }
            } else {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(openApplicationEntity.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_FAILURE_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);
            }
        }
    }

    /**
     * 数据归档
     * 增开
     *
     * @param openAcctList
     */
    private void doArrangeMarginData(List<CustomerAccountMarginOpenApplyEntity> openAcctList) {
        for (CustomerAccountMarginOpenApplyEntity openApplicationEntity : openAcctList) {

            int count = 0;
            CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = customerAccountOpenInfoService.queryByIdCardNumber(openApplicationEntity.getIdCardNo());
            customerAccountOpenInfoEntity.setFundAccountType(2);
            AyersClientInfoEntity clientInfoEntity = ayersAccOpenService.createClientInfoEntity(customerAccountOpenInfoEntity);
            count = ayersAccOpenService.saveClientInfo(clientInfoEntity);

            if (count > 0){
                AyersClientAccEntity clientAccEntity = ayersAccOpenService.createClientAccEntity(customerAccountOpenInfoEntity);
                count = ayersAccOpenService.saveClineAcc(clientAccEntity);
            }

            if (count > 0) {
                SecuritiesUserModel securitiesUserModel = CustomerOpenAccountConverter.converterToSecuritiesUserInfo(customerAccountOpenInfoEntity);
                securitiesUserModel.setFundAccountType(2);
                ResponseVO responseVO = securitiesUserInfoService.addSecuritiesUserInfo(securitiesUserModel);
                logger.info("同步开户数据至统一用户中心结果：" + JSON.toJSONString(responseVO));
                // 驱动流程下一步
                actModelerService.doNextFlow(openApplicationEntity.getApplicationId(), openApplicationEntity.getInstanceId(), "");
            } else {
                // 更新预约申请表相关信息
                CustomerAccountMarginOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountMarginOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(openApplicationEntity.getApplicationId());
                //增开失败
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_FAILURE_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccMarginOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);
            }
        }
    }
}
