package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.protocol.OpenAccResultCallbackProto;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.ProtocolUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 线下开户结果回调任务
 * @author: Larry Lai
 * @date: 2019/10/21 16:45
 * @version: v1.0
 */

@Component("offlineCustAccOpenCallBackJob")
public class OfflineCustAccOpenCallBackJob {
    private final Logger logger = LoggerFactory.getLogger(OfflineCustAccOpenCallBackJob.class);
    @Autowired
    CustomerAccOpenApplyService customerAccountOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    CustomerAccOpenService customerAccOpenService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;

    /**
     * 线下开户结果回调任务
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");
        CustomerAccountOpenApplyEntity queryCondition = new CustomerAccountOpenApplyEntity();
        queryCondition.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
        List<CustomerAccountOpenApplyEntity> customerAccountOpenApplyEntities = customerAccountOpenApplyService.queryListByBean(queryCondition);

        for (CustomerAccountOpenApplyEntity customerAccOpenApplyEntity : customerAccountOpenApplyEntities) {

            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(customerAccOpenApplyEntity.getApplicationId());

            // 开户类型为线下开户
            if (2 == customerAccountOpenInfo.getOpenAccountType()) {


                AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = customerAccOpenService.findByApplicationId(customerAccOpenApplyEntity.getApplicationId());

                List<String> paramList = Lists.newArrayList();

                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE == customerAccOpenApplyEntity.getApplicationStatus()
                        || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {

                    OpenAccResultCallbackProto resultCallbackProto = new OpenAccResultCallbackProto();
                    resultCallbackProto.setClientId(customerAccountOpenInfo.getClientId());
                    resultCallbackProto.setChannelId(customerAccountOpenInfo.getSourceChannelId());
                    resultCallbackProto.setPhoneNumber(customerAccountOpenInfo.getPhoneNumber());
                    resultCallbackProto.setOpenDate(DateUtil.formatDateTime(customerAccountOpenInfo.getOpenAccountTime()));

                    GenericSunlineRequest<OpenAccResultCallbackProto> genericRequest = new GenericSunlineRequest<>();
                    genericRequest.setParams(resultCallbackProto);

                    logger.info("线下开户申请结果回调内容：" + JSON.toJSONString(genericRequest));
                    String response = HttpClientUtils.postJson(ConfigUtils.get("openAccount.callback.offline.url"), JSON.toJSONString(genericRequest));
                    logger.info("线下开户结果回调下游接收结果：" + response);

                    ResponseVO responseVO = JSON.parseObject(response, ResponseVO.class);

                    if (BpmCommonEnum.CodeType.OK.getCode() == responseVO.getCode()) {

                        // 发送邮件通知
                        customerAccOpenService.sendAccountOpenEmail(accountOpenApplicationDetailInfo);

                        paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName());
                        paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientId());
                        paramList.add(ProtocolUtils.getDecryptPhone(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getInitialAccountPassword()));

                        generateOpenAccRetSendSms(1002, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);

                        // 更新小神号
                        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
                        securitiesUserModel.setUserId(JSON.parseObject(JSON.toJSONString(responseVO.getResult())).getIntValue("userId"));
                        securitiesUserModel.setIdKind(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getIdKind());
                        securitiesUserModel.setIdNo(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getIdNo());
                        securitiesUserModel.setTradeAccount(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientId());
                        securitiesUserModel.setFundAccount(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getFundAccount());

                        securitiesUserInfoService.modifySecuritiesUserInfo(securitiesUserModel);

                        customerAccOpenApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                        int isSucceed = customerAccountOpenApplyService.update(customerAccOpenApplyEntity);
                    }
                }
            }
        }
    }


    /**
     * 生成短信发送数据
     *
     * @param phoneNumber
     * @param paramList
     * @param templateCode
     * @return
     */
    public boolean generateOpenAccRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle("智珠证券账户开户申请");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            // 开户文件
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("开户短信发送异常", e);
        }

        return false;
    }
}
