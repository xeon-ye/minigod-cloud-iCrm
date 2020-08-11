package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.entity.FundWithdrawRefundApplyEntity;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
import com.sunline.modules.fund.service.FundWithdrawRefundApplyService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.FundCashDeposit;
import com.sunline.modules.hundsun.protocol.request.FundCashFetchRequest;
import com.sunline.modules.hundsun.protocol.request.FundFrozenCancelRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 客户出金处理结果同步恒生柜台
 * @author: Larry Lai
 * @date: 2019/4/18 10:59
 * @version: v1.0
 */

@Component("fundWithdrawSyncHsJob")
public class FundWithdrawSyncHsJob {

    private static final Logger logger = LoggerFactory.getLogger(FundWithdrawSyncHsJob.class);

    private CrmCommonEnum.FundWithDrawStep fundWithDrawStep;
    private BpmCommonEnum.CommonProcessStatus commonProcessStatus;

    @Autowired
    private ClientFundWithdrawApplyService clientFundWithdrawApplyService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    private FundWithdrawRefundApplyService fundWithdrawRefundApplyService;

    /**
     * 客户出金处理结果同步恒生柜台
     *
     * @param params
     */
    public void excute(String params) {

        logger.info(params + "任务开始");

        //先获取柜台状态
        ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
        if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
            SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
            if ("6".equals(result.getSysStatus()) || "0".equals(result.getBankStatus())) {
                return;
            }
        } else {
            logger.info("获取柜台状态失败");
            return;
        }

        // 出金结果处理
        ClientFundWithdrawApplyEntity withdrawQueryCondition = new ClientFundWithdrawApplyEntity();
        withdrawQueryCondition.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);

        List<ClientFundWithdrawApplyEntity> waitingForFundWithdrawData = clientFundWithdrawApplyService.queryList(withdrawQueryCondition);

        logger.info("客户出金处理结果同步恒生柜台，待处理数据条数：" + waitingForFundWithdrawData.size());

        for (ClientFundWithdrawApplyEntity fundWithdrawData : waitingForFundWithdrawData) {

            commonProcessStatus = BpmCommonEnum.CommonProcessStatus.valueOf(fundWithdrawData.getCallbackStatus());

            // 获取当前步骤
            fundWithDrawStep = getNextStep(fundWithdrawData.getHsBusinessStep());

            // 执行业务操作
            boolean isSecceed = doBiz(fundWithdrawData);

            if (isSecceed) {
                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setCallbackStatus(commonProcessStatus.getNumber());
                clientFundWithdrawApplyEntity.setHsBusinessStep(fundWithDrawStep.getNumber());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
            }
        }

        // 出金退款结果处理
        FundWithdrawRefundApplyEntity refundQueryCondition = new FundWithdrawRefundApplyEntity();
        refundQueryCondition.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);

        List<FundWithdrawRefundApplyEntity> waitingForFundWithdrawRefundData = fundWithdrawRefundApplyService.queryList(refundQueryCondition);

        logger.info("客户出金退款处理结果同步恒生柜台，待处理数据条数：" + waitingForFundWithdrawRefundData.size());

        for (FundWithdrawRefundApplyEntity fundWithdrawRefundData : waitingForFundWithdrawRefundData) {
            CommonResponse fundWithdrawRefundResponse = fundCashDeposit(fundWithdrawRefundData);

            if (null != fundWithdrawRefundResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(fundWithdrawRefundResponse.getCommonErrorCode().getErrorCode())) {

                BigDecimal occurBalance = new BigDecimal(0.00);
                if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "1").equals(String.valueOf(fundWithdrawRefundData.getRefundType()))) {
                    occurBalance = fundWithdrawRefundData.getRefundAmount().subtract(fundWithdrawRefundData.getRefundBankFee());
                }

                if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "2").equals(String.valueOf(fundWithdrawRefundData.getRefundType()))) {
                    occurBalance = fundWithdrawRefundData.getNetRefundAmount();
                }

                logger.info("客户[" + fundWithdrawRefundData.getClientId() + "]出金退款金额[" + occurBalance.setScale(2, BigDecimal.ROUND_HALF_UP).toString()
                        + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawRefundData.getCurrencyType())) + "]已成功入账");

                // 发送短信通知
                List<String> paramList = Lists.newArrayList();

                paramList.clear();
                paramList.add(fundWithdrawRefundData.getClientName() != null ? fundWithdrawRefundData.getClientName() : fundWithdrawRefundData.getClientNameSpell());

                StringBuilder content = new StringBuilder();
                if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "1").equals(String.valueOf(fundWithdrawRefundData.getRefundType()))) {
                    content.append("退款金额为").append(fundWithdrawRefundData.getRefundAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()).append(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawRefundData.getCurrencyType())))
                            .append("，扣除银行手续费").append(fundWithdrawRefundData.getRefundBankFee().setScale(2, BigDecimal.ROUND_HALF_UP).toString()).append(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawRefundData.getCurrencyType()))).append("，");
                }

                paramList.add(String.valueOf(content));
                paramList.add(occurBalance.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawRefundData.getCurrencyType())));


                // 发送短信
                generateSendSms(2011, fundWithdrawRefundData.getPhoneNumber(), paramList);

                // 更新回调状态
                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundData.getApplicationId());
                fundWithdrawRefundApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));
                fundWithdrawRefundApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                fundWithdrawRefundApplyService.updateByApplicationId(fundWithdrawRefundApplyEntity);
            } else {
                String msg = "预约流水号：" + fundWithdrawRefundData.getApplicationId() + " 出金退款入账失败，失败原因：" + JSON.toJSONString(fundWithdrawRefundResponse != null ? fundWithdrawRefundResponse.getDataResult() : "");
                generateSendEmail("【系统异常】CUBP系統出金退款", msg);

                // 更新回调状态
                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundData.getApplicationId());
                fundWithdrawRefundApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                fundWithdrawRefundApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                fundWithdrawRefundApplyService.updateByApplicationId(fundWithdrawRefundApplyEntity);
            }
        }
    }

    /**
     * 执行业务处理
     *
     * @return
     */
    private boolean doBiz(ClientFundWithdrawApplyEntity fundWithdrawData) {

        boolean isSecceed = false;

        switch (fundWithDrawStep) {
            case FUND_WITHDRAW_SFUND_CASH_GD_FETCH:

                if (BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_SUCCESS_VALUE == fundWithdrawData.getWithdrawStatus()) {

                    CommonResponse fundCashFetchResponse = fundCashFetch(fundWithdrawData);

                    if (null != fundCashFetchResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(fundCashFetchResponse.getCommonErrorCode().getErrorCode())) {

                        logger.info("客户[" + fundWithdrawData.getClientId() + "]提取金额[" + fundWithdrawData.getOccurBalance()
                                + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawData.getMoneyType())) + "]已成功扣款");

                        CommonResponse fundFrozenCancelResponse = fundFrozenCancel(fundWithdrawData);

                        if (null != fundFrozenCancelResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(fundFrozenCancelResponse.getCommonErrorCode().getErrorCode())) {

                            logger.info("客户[" + fundWithdrawData.getClientId() + "]冻结资金[" + fundWithdrawData.getOccurBalance()
                                    + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawData.getMoneyType())) + "]已成功解冻");

                            // 设置下一步
                            fundWithDrawStep = getNextStep(fundWithDrawStep.getNumber());

                            commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                            ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                            clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));
                            clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                            clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                            clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        } else {
                            // 出金异常通知
                            commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                            String msg = "预约流水号：" + fundWithdrawData.getApplicationId() + " 出金扣款失败，失败原因：" + JSON.toJSONString(fundCashFetchResponse.getDataResult());
                            generateSendEmail("【系统异常】CUBP系統出金业务", msg);

                            ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                            clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                            clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                            clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                            clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        }

                        isSecceed = true;
                    } else {
                        // 出金异常通知
                        commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                        String msg = "预约流水号：" + fundWithdrawData.getApplicationId() + " 出金扣款失败，失败原因：" + JSON.toJSONString(fundCashFetchResponse != null ? fundCashFetchResponse.getDataResult() : "");
                        generateSendEmail("【系统异常】CUBP系統出金业务", msg);

                        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                        clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                        clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                        clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        isSecceed = true;
                    }
                }

                if (BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_FAILURE_VALUE == fundWithdrawData.getWithdrawStatus()) {

                    CommonResponse fundFrozenCancelResponse = fundFrozenCancel(fundWithdrawData);

                    if (null != fundFrozenCancelResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(fundFrozenCancelResponse.getCommonErrorCode().getErrorCode())) {

                        logger.info("客户[" + fundWithdrawData.getClientId() + "]的冻结资金[" + fundWithdrawData.getOccurBalance()
                                + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawData.getMoneyType())) + "]已成功解冻");

                        fundWithDrawStep = getNextStep(fundWithDrawStep.getNumber());

                        commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                        clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));
                        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                        clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                        clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        isSecceed = true;
                    } else {
                        // 出金异常通知
                        commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                        String msg = "预约流水号：" + fundWithdrawData.getApplicationId() + " 出金扣款失败，失败原因：" + JSON.toJSONString(fundFrozenCancelResponse != null ? fundFrozenCancelResponse.getDataResult() : "");
                        generateSendEmail("【系统异常】CUBP系統出金业务", msg);

                        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                        clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                        clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                        clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        isSecceed = true;
                    }
                }

                break;
            case FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL:

                if (BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_SUCCESS_VALUE == fundWithdrawData.getWithdrawStatus()) {

                    CommonResponse fundFrozenCancelResponse = fundFrozenCancel(fundWithdrawData);

                    if (null != fundFrozenCancelResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(fundFrozenCancelResponse.getCommonErrorCode().getErrorCode())) {

                        logger.info("客户[" + fundWithdrawData.getClientId() + "]冻结资金[" + fundWithdrawData.getOccurBalance()
                                + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(fundWithdrawData.getMoneyType())) + "]已成功解冻");

                        commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;

                        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                        clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));
                        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                        clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                        clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        isSecceed = true;
                    } else {
                        // 出金异常通知
                        commonProcessStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;
                        String msg = "预约流水号：" + fundWithdrawData.getApplicationId() + " 出金扣款失败，失败原因：" + JSON.toJSONString(fundFrozenCancelResponse != null ? fundFrozenCancelResponse.getDataResult() : "");
                        generateSendEmail("【系统异常】CUBP系統出金业务", msg);

                        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                        clientFundWithdrawApplyEntity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
                        clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawData.getApplicationId());

                        clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);
                        isSecceed = true;
                    }
                }

                break;
            default:
                isSecceed = false;
        }

        return isSecceed;
    }

    /**
     * 获取出金步骤的下一步
     *
     * @param hsBusinessStep
     * @return
     */
    private CrmCommonEnum.FundWithDrawStep getNextStep(Integer hsBusinessStep) {

        if (null == hsBusinessStep) {
            return CrmCommonEnum.FundWithDrawStep.FUND_WITHDRAW_SFUND_CASH_GD_FETCH;
        }

        CrmCommonEnum.FundWithDrawStep currentFundWithDrawStep = CrmCommonEnum.FundWithDrawStep.valueOf(hsBusinessStep);

        if (currentFundWithDrawStep == CrmCommonEnum.FundWithDrawStep.FUND_WITHDRAW_SFUND_CASH_GD_FETCH) {
            return CrmCommonEnum.FundWithDrawStep.FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL;
        }

        if (currentFundWithDrawStep == CrmCommonEnum.FundWithDrawStep.FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL) {
            return null;
        }

        return null;
    }

    /**
     * 资金取出
     *
     * @param fundWithdrawData
     * @return
     */
    private CommonResponse fundCashFetch(ClientFundWithdrawApplyEntity fundWithdrawData) {
        FundCashFetchRequest fundCashFetchRequest = new FundCashFetchRequest();
        fundCashFetchRequest.setActionIn(1);
        fundCashFetchRequest.setAuditAction("1");
        fundCashFetchRequest.setClientId(fundWithdrawData.getClientId());
        fundCashFetchRequest.setFundAccount(Integer.parseInt(fundWithdrawData.getFundAccount()));
        fundCashFetchRequest.setPassword("");
        fundCashFetchRequest.setMoneyType(fundWithdrawData.getMoneyType());
        fundCashFetchRequest.setOccurbalance(fundWithdrawData.getOccurBalance());
        fundCashFetchRequest.setRemark("FUND WITHDRAWAL-" + fundWithdrawData.getBankNo());
        fundCashFetchRequest.setLocaleRemark("出金" + "-" + fundWithdrawData.getBankName() + "-" + fundWithdrawData.getBankNo());
        fundCashFetchRequest.setValueDate(Integer.valueOf(DateUtil.format(fundWithdrawData.getUpdateTime(), "yyyyMMdd")));
        fundCashFetchRequest.setFeeMoneyType(fundWithdrawData.getMoneyType());
        fundCashFetchRequest.setPayee(fundWithdrawData.getClientNameSpell());
        fundCashFetchRequest.setBusinessFlagReal(0);
        fundCashFetchRequest.setTheThird("0");
        fundCashFetchRequest.setExStatus("1");
        fundCashFetchRequest.setOverdraftForcedFlag("1");
        fundCashFetchRequest.setBankId(fundWithdrawData.getHsBankId());
        fundCashFetchRequest.setBankAccount(fundWithdrawData.getHsBankAccount());

        return HsCommManageService.send("hundsunProxyService/fundCashFetch.do", fundCashFetchRequest);
    }

    /**
     * 资金解冻
     *
     * @param fundWithdrawData
     * @return
     */
    private CommonResponse fundFrozenCancel(ClientFundWithdrawApplyEntity fundWithdrawData) {

        FundFrozenCancelRequest fundFrozenCancelRequest = new FundFrozenCancelRequest();
        fundFrozenCancelRequest.setActionIn(1);
        fundFrozenCancelRequest.setAuditAction("1");
        fundFrozenCancelRequest.setJourDate(fundWithdrawData.getInitDate());
        fundFrozenCancelRequest.setJourSerialNo(fundWithdrawData.getRevertSerialNo());
        fundFrozenCancelRequest.setCancelBalance(fundWithdrawData.getOccurBalance());
        fundFrozenCancelRequest.setOccurbalance(fundWithdrawData.getOccurBalance());

        return HsCommManageService.send("hundsunProxyService/fundFrozenCancel.do", fundFrozenCancelRequest);
    }

    /**
     * 资金存入
     *
     * @param fundWithdrawRefundData
     * @return
     */
    private CommonResponse fundCashDeposit(FundWithdrawRefundApplyEntity fundWithdrawRefundData) {
        FundCashDeposit.FundCashDepositRequest fundCashDepositRequest = new FundCashDeposit.FundCashDepositRequest();
        fundCashDepositRequest.setActionIn(1);
        fundCashDepositRequest.setAuditAction("1");
        fundCashDepositRequest.setClientId(fundWithdrawRefundData.getClientId());
        fundCashDepositRequest.setFundAccount(Integer.valueOf(fundWithdrawRefundData.getFundAccount()));
        fundCashDepositRequest.setPassword("");
        fundCashDepositRequest.setMoneyType(fundWithdrawRefundData.getCurrencyType());

        if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "1").equals(String.valueOf(fundWithdrawRefundData.getRefundType()))) {
            fundCashDepositRequest.setOccurbalance(fundWithdrawRefundData.getRefundAmount().subtract(fundWithdrawRefundData.getRefundBankFee()));
        }

        if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "2").equals(String.valueOf(fundWithdrawRefundData.getRefundType()))) {
            fundCashDepositRequest.setOccurbalance(fundWithdrawRefundData.getNetRefundAmount());
        }

        fundCashDepositRequest.setRemark("withdrawal refund");
        fundCashDepositRequest.setLocaleRemark("出金退款");
        fundCashDepositRequest.setFeeMoneyType(fundWithdrawRefundData.getCurrencyType());
        fundCashDepositRequest.setBusinessFlagReal(0);
        fundCashDepositRequest.setTheThird("0");
        fundCashDepositRequest.setExStatus("1");
        fundCashDepositRequest.setBankId(fundWithdrawRefundData.getHsBankId());
        fundCashDepositRequest.setBankAccount(fundWithdrawRefundData.getHsBankAccount());

        return HsCommManageService.send("hundsunProxyService/fundCashDeposit.do", fundCashDepositRequest);
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
                +";"+ SysConfigUtil.getSysConfigValue("SETTL_DEPART_GROUP", "settl_dept@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }

    /**
     * 出金业务短信通知生成
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @return
     */
    private boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
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
            messageSendInfoEntity.setMessageTitle("宝新证券出金业务通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("出金业务短信发送异常", e);
        }

        return false;
    }
}
