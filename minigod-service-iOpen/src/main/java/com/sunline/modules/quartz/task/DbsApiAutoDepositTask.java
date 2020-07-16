package com.sunline.modules.quartz.task;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.analysis.service.MoneyRateInfoService;
import com.sunline.modules.api.dao.SecuritiesUserInfoDao;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.entity.DbsIccDepositConfigEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import com.sunline.modules.fund.service.DbsIccDepositConfigService;
import com.sunline.modules.fund.service.DepositBankBillFlowService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: DBS API自动化入金调度任务
 * @author: Larry Lai
 * @date: 2020/3/3 16:11
 * @version: v1.0
 */

@Component("dbsApiAutoDepositTask")
public class DbsApiAutoDepositTask {

    private static final Logger logger = LoggerFactory.getLogger(DbsApiAutoDepositTask.class);

    @Autowired
    private ClientFundDepositApplicationService fundDepositApplyService;
    @Autowired
    ClientBankCardInfoService clientBankCardInfoService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    private SecuritiesUserInfoDao securitiesUserInfoDao;
    @Autowired
    private DepositBankBillFlowService depositBankBillFlowService;
    @Autowired
    private DbsIccDepositConfigService dbsIccDepositConfigService;
    @Autowired
    private MoneyRateInfoService moneyRateInfoService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    public void excute(String params) {

        logger.info(params + "任务开始");

        DepositBankBillFlowEntity depositBankBillFlowEntity = new DepositBankBillFlowEntity();
        depositBankBillFlowEntity.setFlowSource(1);
        depositBankBillFlowEntity.setCheckStatus(0);
        //手续费状态必须成功
        depositBankBillFlowEntity.setAreEnqStatus("ACSP");
        depositBankBillFlowEntity.setAssignDrafter(UserUtils.getBackgroundWorkflowUser().getId());

        List<DepositBankBillFlowEntity> depositBankBillFlowList = depositBankBillFlowService.queryListByBean(depositBankBillFlowEntity);

        for (DepositBankBillFlowEntity info : depositBankBillFlowList) {

            // 汇款账号且汇款帐户名称不为空，are手续费不能为空
            if (StringUtils.isNotBlank(info.getSenderAccNo()) && StringUtils.isNotBlank(info.getSenderAccName())
                && info.getAreChargeMoney()!=null) {

                List<ClientFundDepositApplicationEntity> clientFundDepositApplyList = getDepositApplyList(info);

                if (null != clientFundDepositApplyList && clientFundDepositApplyList.size() > 0) {

                    // 若匹配多条入金申请，只取其中一条做自动化入金
                    ClientFundDepositApplicationEntity clientFundDepositApplyInfo = clientFundDepositApplyList.get(0);

                    // 申领任务锁定入金申请
                    ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(clientFundDepositApplyInfo.getApplicationId());
                    Result result = actModelerService.applyTaskHandle(taskDto, UserUtils.getBackgroundWorkflowUser().getId());
                    if ("0".equals(result.get("code"))) {
                        // 更新申请表指定处理人
                        clientFundDepositApplyInfo.setAssignDrafter(UserUtils.getBackgroundWorkflowUser().getId());
                        clientFundDepositApplyInfo.setUpdateTime(new Date());
                        fundDepositApplyService.updateAssignDrafter(clientFundDepositApplyInfo);
                    }

                    logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已匹配入金申请[" + clientFundDepositApplyInfo.getApplicationId() + "]");

                    SecuritiesUserModel request = new SecuritiesUserModel();
                    request.setClientStatus("0");
                    request.setTradeAccount(clientFundDepositApplyInfo.getClientId());
                    SecuritiesUserModel securitiesUserInfo = securitiesUserInfoDao.queryObject(request);

                    // 获取dbs api自动化入金配置
                    DbsIccDepositConfigEntity queryCondition = new DbsIccDepositConfigEntity();
                    queryCondition.setCcy(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundDepositApplyInfo.getMoneyType())));
                    queryCondition.setIsInvalid(0);
                    queryCondition.setValidTime(new Date());
                    List<DbsIccDepositConfigEntity> dbsIccDepositConfigList = dbsIccDepositConfigService.queryListByBean(queryCondition);

                    if (null != securitiesUserInfo && securitiesUserInfo.getBankType() == 1) {
                        // 非香港银行卡开户
                        logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已匹配非香港卡开户客户[" + securitiesUserInfo.getTradeAccount() + "]");

                        if (null != dbsIccDepositConfigList && dbsIccDepositConfigList.size() > 0) {

                            int compareMaxNum = info.getCreditAmount().compareTo(dbsIccDepositConfigList.get(0).getMaxAmount());

                            // 未触达入金上限
                            if (compareMaxNum != 1) {
                                autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                            } else {
                                // 释放并重置
                                reset(clientFundDepositApplyInfo.getApplicationId(), info);
                            }
                        } else {
                            autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                        }

                    } else if (null != securitiesUserInfo && securitiesUserInfo.getBankType() == 0) {
                        // 香港银行卡开户
                        logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已匹配香港卡开户客户[" + securitiesUserInfo.getTradeAccount() + "]");

                        if (clientFundDepositApplyInfo.getIsBanding() > 0) {
                            // 客户非首次用该账号入金

                            logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已匹配香港卡开户客户[" + securitiesUserInfo.getTradeAccount()
                                    + "]，客户非首次用该汇款账号[" + clientFundDepositApplyInfo.getDepositNo() + "]入金");

                            if (null != dbsIccDepositConfigList && dbsIccDepositConfigList.size() > 0) {

                                int compareMaxNum = info.getCreditAmount().compareTo(dbsIccDepositConfigList.get(0).getMaxAmount());

                                // 未触达入金上限
                                if (compareMaxNum != 1) {
                                    autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                                } else {
                                    // 释放并重置
                                    reset(clientFundDepositApplyInfo.getApplicationId(), info);
                                }
                            } else {
                                autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                            }
                        } else {
                            // 客户首次用该账号入金

                            logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已匹配香港卡开户客户[" + securitiesUserInfo.getTradeAccount()
                                    + "]，客户首次用该汇款账号[" + clientFundDepositApplyInfo.getDepositNo() + "]入金");

                            int compareReachNum;
                            // 换汇
                            if ("1".equals(clientFundDepositApplyInfo.getMoneyType())) {
                                BigDecimal exchangeAmt = moneyRateInfoService.exchange(clientFundDepositApplyInfo.getMoneyType(), "2", info.getCreditAmount());
                                if (exchangeAmt.compareTo(new BigDecimal(0)) != 0) {
                                    compareReachNum = exchangeAmt.compareTo(new BigDecimal(9980));
                                } else {
                                    compareReachNum = info.getCreditAmount().compareTo(new BigDecimal(9980));
                                }
                            } else {
                                compareReachNum = info.getCreditAmount().compareTo(new BigDecimal(9980));
                            }

                            // 到账金额达成9980港币或者等值货币
                            if (compareReachNum == 1) {

                                if (null != dbsIccDepositConfigList && dbsIccDepositConfigList.size() > 0) {
                                    int compareMaxNum = info.getCreditAmount().compareTo(dbsIccDepositConfigList.get(0).getMaxAmount());

                                    // 未触达入金上限
                                    if (compareMaxNum != 1) {
                                        autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                                    } else {
                                        // 释放并重置
                                        reset(clientFundDepositApplyInfo.getApplicationId(), info);
                                    }
                                } else {
                                    autoAudit(clientFundDepositApplyInfo.getApplicationId(), info);
                                }
                            } else {
                                // 释放并重置
                                reset(clientFundDepositApplyInfo.getApplicationId(), info);
                            }
                        }

                    } else {
                        logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]未匹配开户客户");
                        // 释放并重置
                        reset(clientFundDepositApplyInfo.getApplicationId(), info);
                    }
                }
            }
        }
    }

    /**
     * 是否超出入金金额限制
     *
     * @param fromMoneyType
     * @param amount
     * @param maxAmount
     * @return
     */
    private int isRestrict(String fromMoneyType, BigDecimal amount, BigDecimal maxAmount) {
        int compareMaxNum;

        if ("1".equals(fromMoneyType)) {
            BigDecimal exchangeAmt = moneyRateInfoService.exchange(fromMoneyType, "2", amount);
            if (exchangeAmt.compareTo(new BigDecimal(0)) != 0) {
                compareMaxNum = exchangeAmt.compareTo(maxAmount);
            } else {
                compareMaxNum = amount.compareTo(maxAmount);
            }
        } else {
            compareMaxNum = amount.compareTo(maxAmount);
        }

        return compareMaxNum;
    }

    /**
     * 自动完成入金流程
     *
     * @param applicationId
     * @param info
     * @return
     */
    private boolean autoAudit(String applicationId, DepositBankBillFlowEntity info) {

        ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(applicationId);
        taskDto.setRemark("程序自动入账-审核通过");

        try {
            boolean isSucceed;

            isSucceed = doAutoPass(taskDto);
            if (isSucceed) {

                // 更新已核对银行流水
                info.setCheckStatus(1);
                info.setApplicationId(applicationId);
                info.setUpdateTime(new Date());
                info.setUpdateUser(UserUtils.getBackgroundWorkflowUser().getId());
                info.setAssignDrafter(UserUtils.getBackgroundWorkflowUser().getId());

                int count = depositBankBillFlowService.update(info);

                if (count > 0) {
                    taskDto = actModelerService.findProcessTaskByBusId(applicationId);
                    taskDto.setRemark("程序自动入账-入账通过");
                    isSucceed = doAutoPass(taskDto);

                    if (isSucceed) {
                        logger.info("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]已完成自动化入金流程");
                        return isSucceed;
                    }
                }
            }

            return false;
        } catch (Exception e) {

            // 释放并重置
            reset(applicationId, info);

            logger.error("【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]自动化入金流程出现异常", e);
            String msg = "【DBS API Auto Deposit】MsgId[" + info.getMsgId() + "]自动化入金流程出现异常，失败原因：" + e.getMessage();
            generateSendEmail("【CUBP系统异常】DBS API自动化入金", msg);
            return false;
        }
    }

    /**
     * 释放并重置
     *
     * @param info
     * @param applicationId
     * @return
     */
    private boolean reset(String applicationId, DepositBankBillFlowEntity info) {

        ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(applicationId);

        Result result = actModelerService.deliverTaskHandle(taskDto);

        if ("0".equals(result.get("code"))) {
            // 更新申请表指定处理人
            ClientFundDepositApplicationEntity depositApplicationEntity = fundDepositApplyService.queryByApplicationId(taskDto.getBusId());

            depositApplicationEntity.setAssignDrafter(null);
            depositApplicationEntity.setUpdateTime(new Date());
            fundDepositApplyService.updateAssignDrafter(depositApplicationEntity);

            // 更新已核对银行流水
            info.setCheckStatus(0);
            info.setApplicationId(null);
            info.setUpdateTime(new Date());
            info.setUpdateUser(UserUtils.getBackgroundWorkflowUser().getId());
            info.setAssignDrafter(null);
            depositBankBillFlowService.update(info);
            depositBankBillFlowService.updateAssignDrafter(info);
        }

        return false;
    }

    /**
     * 匹配入金申请
     *
     * @param depositBankBillFlowEntity
     * @return
     */
    private List<ClientFundDepositApplicationEntity> getDepositApplyList(DepositBankBillFlowEntity depositBankBillFlowEntity) {
        ClientFundDepositApplicationEntity depQueryCondition = new ClientFundDepositApplicationEntity();
        depQueryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE);
        depQueryCondition.setBenefitBank("1");
        depQueryCondition.setMoneyType(depositBankBillFlowEntity.getCurrency());
        depQueryCondition.setBenefitNo(depositBankBillFlowEntity.getSubAccno());
        depQueryCondition.setDepositNo(depositBankBillFlowEntity.getSenderAccNo());
        depQueryCondition.setDepositAccount(depositBankBillFlowEntity.getSenderAccName());
        //depQueryCondition.setDepositBalance(depositBankBillFlowEntity.getCreditAmount());
        depQueryCondition.setDepositBalance(depositBankBillFlowEntity.getActualMoney());
        return fundDepositApplyService.queryListByBean(depQueryCondition);
    }

    /**
     * 工作流自动审核
     *
     * @param processTaskDto
     * @return
     */
    private boolean doAutoPass(ProcessTaskDto processTaskDto) {

        boolean isSecceed = validateProcessTaskDtoIsFull(processTaskDto);

        try {
            if (isSecceed) {
                actModelerService.doActTask(processTaskDto, null);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            logger.error("工作流自动审核异常", e);
        }

        return false;
    }

    /**
     * 校验工作流对象
     *
     * @param processTaskDto
     * @return
     */
    private static boolean validateProcessTaskDtoIsFull(ProcessTaskDto processTaskDto) {

        if (StringUtils.isBlank(processTaskDto.getTaskId())) {
            logger.error("任务ID不能为空");
            return false;
        }
        if (StringUtils.isBlank(processTaskDto.getDefId())) {
            logger.error("流程定义ID不能为空");
            return false;
        }
        if (StringUtils.isBlank(processTaskDto.getInstanceId())) {
            logger.error("实例ID不能为空");
            return false;
        }
        if (StringUtils.isBlank(processTaskDto.getBusId())) {
            logger.error("业务ID不能为空");
            return false;
        }

        return true;
    }

    /**
     * 发送邮件通知
     *
     * @param title
     * @param message
     */
    private void generateSendEmail(String title, String message) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com")
                + ";" + SysConfigUtil.getSysConfigValue("SETTL_DEPART_GROUP", "settl_dept@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }

}
