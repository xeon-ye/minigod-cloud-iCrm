package com.sunline.modules.quartz.task;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.proxy.request.FundDepositResultRequest;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.FundCashDeposit;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 客户入金同步恒生柜台
 */
@Component("clientDespositToHsTask")
public class ClientDespositSyscHsTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientFundDepositApplicationService clientFundDepositApplicationService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    @Autowired
    private ClientBankCardInfoService clientBankCardInfoService;

    /**
     * 客户入金同步
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
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

        ClientFundDepositApplicationEntity query = new ClientFundDepositApplicationEntity();
        query.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        query.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_VALUE);
        List<ClientFundDepositApplicationEntity> applicationEntities = clientFundDepositApplicationService.queryList(query);

        logger.info("客户入金同步恒生柜台，待处理条数：" + applicationEntities.size());

        for (ClientFundDepositApplicationEntity entity : applicationEntities) {
            try {
                CommonResponse response = fundCashDeposit(entity);
                if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                    entity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_SUCCESS_VALUE);
                    entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));
                    entity.setEntryTime(new Date());

                    List<String> paramList = Lists.newArrayList();
                    paramList.add(entity.getClientName() != null ? entity.getClientName() : entity.getClientNameSpell());
                    paramList.add(entity.getDepositBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", entity.getMoneyType()));
                    paramList.add(entity.getBenefitBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", entity.getMoneyType()));
                    clientFundDepositApplicationService.generateSendSms(2016, entity.getPhoneNumber(), paramList);
                    //添加银行卡
                    addBankCard(entity);
                } else {
                    logger.info("客户入金同步恒生柜台失败，预约号：{}",entity.getApplicationId());
                    entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                    entity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_FAIL_VALUE);
                    generateSendEmail("【系统异常】CUBP入金业务", "同步恒生柜台失败"+entity.getApplicationId() + "——" + JSON.toJSONString(response != null ? response : ""));
                }
            } catch (Exception e) {
                logger.info("客户入金同步恒生柜台异常，预约号：{}",entity.getApplicationId());
                entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                entity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_FAIL_VALUE);
                generateSendEmail("【系统异常】CUBP入金业务", "同步恒生柜台失败"+entity.getApplicationId() + "——" + e.getMessage());
            }
            entity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
            entity.setUpdateTime(new Date());
            clientFundDepositApplicationService.update(entity);
            //回调中台
            clientFundDepositApplicationService.pushFundDepositResult(new FundDepositResultRequest(entity.getApplicationId(), 3,null));
        }
    }

    /**
     * 银行卡存入
     */
    private void addBankCard(ClientFundDepositApplicationEntity applicationEntity) {
        ClientBankCardInfoEntity entity = new ClientBankCardInfoEntity();
        //entity.setBankName(applicationEntity.getDepositBank());
        entity.setBankAccount(applicationEntity.getDepositAccount());
        entity.setBankNo(applicationEntity.getDepositNo());
        entity.setStatus(1);
        List<ClientBankCardInfoEntity> bankCards = clientBankCardInfoService.queryListByBean(entity);
        if (CollectionUtil.isEmpty(bankCards)) {
            entity.setClientId(applicationEntity.getClientId());
            entity.setFundAccount(applicationEntity.getFundAccount());
            entity.setBankType(applicationEntity.getDepositType());
            entity.setBankName(applicationEntity.getDepositBank());
            entity.setBankCode(applicationEntity.getDepositBankCode());
            entity.setBankNo(applicationEntity.getDepositNo());
            entity.setBankAccount(applicationEntity.getDepositAccount());
            entity.setStatus(1);
            entity.setRegisterTime(new Date());
            entity.setCreateTime(new Date());
            entity.setCreateUser(UserUtils.getBackgroundWorkflowUser().getId());
            clientBankCardInfoService.save(entity);
        }
    }

    /**
     * 资金存入
     *
     * @param
     * @return
     */
    private CommonResponse fundCashDeposit(ClientFundDepositApplicationEntity fundDepositApplicationEntity) {
        FundCashDeposit.FundCashDepositRequest fundCashDepositRequest = new FundCashDeposit.FundCashDepositRequest();
        fundCashDepositRequest.setActionIn(1);
        fundCashDepositRequest.setAuditAction("1");
        fundCashDepositRequest.setClientId(fundDepositApplicationEntity.getClientId());
        fundCashDepositRequest.setFundAccount(Integer.valueOf(fundDepositApplicationEntity.getFundAccount()));
        fundCashDepositRequest.setPassword("");
        fundCashDepositRequest.setMoneyType(fundDepositApplicationEntity.getMoneyType());
        fundCashDepositRequest.setOccurbalance(fundDepositApplicationEntity.getBenefitBalance());
        fundCashDepositRequest.setRemark("FUND DEPOSIT-" + DateUtil.format(fundDepositApplicationEntity.getBankEntryTime(), "yyyy/MM/dd"));
        fundCashDepositRequest.setLocaleRemark("存入资金-" + DateUtil.format(fundDepositApplicationEntity.getBankEntryTime(), "yyyy/MM/dd"));
        fundCashDepositRequest.setFeeMoneyType(fundDepositApplicationEntity.getMoneyType());
        fundCashDepositRequest.setBusinessFlagReal(0);
        fundCashDepositRequest.setTheThird("0");
        fundCashDepositRequest.setExStatus("1");
        fundCashDepositRequest.setBankId(fundDepositApplicationEntity.getHsBankId());
        fundCashDepositRequest.setBankAccount(fundDepositApplicationEntity.getHsBankAccount());

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
                +";"+SysConfigUtil.getSysConfigValue("SETTL_DEPART_GROUP", "settl_dept@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }
}
