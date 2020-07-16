package com.sunline.modules.account.offline.service.impl;

import java.util.Date;

import com.sunline.modules.common.utils.UserUtils;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunline.modules.account.offline.service.CustAccOpenOfflineService;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.CustomerAccOpenApproveInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.account.online.service.OpenAccountProcessLogService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.CodeUtils;

/**
 * 类的功能描述
 *
 * @author fuyy
 * @date 2018年10月29日 下午6:17:29
 */
@Service("custAccOpenOfflineService")
public class CustAccOpenOfflineServiceImpl implements CustAccOpenOfflineService {
    private static final Logger logger = LoggerFactory.getLogger(CustAccOpenOfflineServiceImpl.class);
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenService customerAccOpenService;
    @Autowired
    CustomerAccountOpenApplyDao customerAccountOpenApplyDao;

    private final String CUSTOMER_ACCOUNT_OPEN_OFFLINE_FLOW_MODEL_KEY = "customerAccountOpenApplicationOffline";

    @Override
    public boolean terminateAccountOpenApplication(CustomerAccountOpenApplyEntity customerAccountOpenApply, ProcessTaskDto processTaskDto, int applicationStatus) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        customerAccOpenApplyService.update(customerAccountOpenApply);

        CustomerAccOpenApproveInfo customerAccountOpenApproveInfo = new CustomerAccOpenApproveInfo();
        customerAccountOpenApproveInfo.setApplicationId(customerAccountOpenApply.getApplicationId());
        customerAccountOpenApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7"));

        // 更新预约申请表相关信息
        CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
        customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
        customerAccOpenApplyEntity.setApplicationStatus(applicationStatus);
        customerAccOpenApplyEntity.setUpdateTime(new Date());
        customerAccOpenApplyEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
        customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
        customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

        approveCallback(customerAccountOpenApproveInfo, processTaskDto, null);

        return true;
    }

    /**
     * 工作流回调业务处理
     *
     * @param customerAccountOpenApproveInfo
     * @param processTaskDto
     * @param task
     */
    @Override
    public void approveCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task) {

        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

            AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = customerAccOpenService.findByApplicationId(customerAccountOpenApproveInfo.getApplicationId());
            CustomerAccountOpenApplyEntity applicationInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity();
            CustomerAccountOpenInfoEntity accountOpenInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

            // 复审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "2").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 开户文件生成
                if (2 == accountOpenInfo.getOpenAccountType()) {
                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT);
                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_W8_REPORT);
                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT);
                }

                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RECHECK_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 终审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "3").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_FINAL_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 开户节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "4").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_PROGRESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 归档节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "5").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);

                customerAccOpenReportGenerate.generateReport(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);


                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                customerAccOpenApplyEntity.setFireAid(0);

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);


            }

            // 完成节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "6").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                if (!CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7").equals(applicationInfo.getCurrentNode())) {
                    // 新增客户开户业务流程日志记录
                    OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                    openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                    openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                    openAccountProcessLogEntity.setTaskId(null);
                    openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                    openAccountProcessLogEntity.setCreateTime(new Date());
                    openAccountProcessLogService.save(openAccountProcessLogEntity);
                }
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 更新流程信息
//					applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
                applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                applicationInfo.setStatus(Constant.ActStauts.END.getValue());
                applicationInfo.setActResult("2");
                applicationInfo.setFireAid(0);

                // 更新开户信息记录为无效记录
                CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
                customerAccountOpenInfoEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccountOpenInfoEntity.setRecordStatus(BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_DISABLE_VALUE);
                customerAccountOpenInfoService.update(customerAccountOpenInfoEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(null);
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);

            }

            // 拼接流程审核记录串
            String flowPath = applicationInfo.getFlowPath() != null ? applicationInfo.getFlowPath() + "-" + customerAccountOpenApproveInfo.getCurrentNode() : customerAccountOpenApproveInfo.getCurrentNode();
            applicationInfo.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
            applicationInfo.setFlowPath(flowPath);
            applicationInfo.setIsBack(null);
            applicationInfo.setApplicationStatus(null);
            applicationInfo.setLastApprovalUser(null);
            applicationInfo.setApprovalOpinion(null);
            applicationInfo.setAssignDrafter(null);
            applicationInfo.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "0").equals(customerAccountOpenApproveInfo.getCurrentNode())
                    && accountOpenInfo.getRecordStatus() != BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_DISABLE_VALUE) {
                customerAccOpenApplyService.update(applicationInfo);
            }

            // 重置指定处理人为null
            customerAccountOpenApplyDao.updateAssignDrafter(applicationInfo);

        } catch (Exception e) {
            logger.error("工作流回调业务处理异常", e);
        }
    }
}

