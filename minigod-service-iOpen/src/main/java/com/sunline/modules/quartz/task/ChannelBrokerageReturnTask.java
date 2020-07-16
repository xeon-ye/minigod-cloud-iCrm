package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.sunline.modules.analysis.entity.ChannelReturnEntity;
import com.sunline.modules.analysis.service.ChannelReturnService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.hundsun.protocol.request.FundCashDeposit;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * @description: 渠道返佣同步恒生柜台
 * @author: Larry Lai
 * @date: 2019/6/11 15:10
 * @version: v1.0
 */

@Component("channelBrokerageReturnTask")
public class ChannelBrokerageReturnTask {

    private static final Logger logger = LoggerFactory.getLogger(ChannelBrokerageReturnTask.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy", Locale.UK);

    @Autowired
    private ChannelReturnService channelReturnService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    /**
     * 渠道返佣同步恒生柜台
     *
     * @param params
     */
    public void excute(String params) {

        ChannelReturnEntity queryCondition = new ChannelReturnEntity();
        queryCondition.setEntryStatus(1);

        List<ChannelReturnEntity> waitingForChannelReturnData = channelReturnService.queryList(queryCondition);

        ChannelReturnEntity entryNarrative = channelReturnService.queryEntryNarrative(queryCondition);

        for (ChannelReturnEntity data : waitingForChannelReturnData) {
            CommonResponse response = fundCashDeposit(data, entryNarrative);

            if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {

                logger.info("客户[" + data.getClientId() + "]返佣金额[20HKD]已成功入账");
                data.setEntryStatus(2);

            } else {

                logger.info("客户[" + data.getClientId() + "]返佣金额[20HKD]入账失败");

                String msg = "预约流水号：" + data.getClientId() + " 返佣入账失败，失败原因：" + JSON.toJSONString(response != null ? response.getDataResult() : "");
                generateSendEmail("【系统异常】CUBP系統渠道返佣", msg);

                data.setEntryStatus(3);
            }

            channelReturnService.update(data);
        }

    }

    /**
     * 资金存入
     *
     * @param data
     * @return
     */
    private CommonResponse fundCashDeposit(ChannelReturnEntity data, ChannelReturnEntity entryNarrative) {

        FundCashDeposit.FundCashDepositRequest fundCashDepositRequest = new FundCashDeposit.FundCashDepositRequest();
        fundCashDepositRequest.setActionIn(1);
        fundCashDepositRequest.setAuditAction("1");
        fundCashDepositRequest.setClientId(data.getClientId());
        fundCashDepositRequest.setFundAccount(Integer.valueOf(data.getFundAccount()));
        fundCashDepositRequest.setPassword("");
        fundCashDepositRequest.setMoneyType(data.getMoneyType());

        fundCashDepositRequest.setOccurbalance(new BigDecimal(20));

        fundCashDepositRequest.setRemark("commission refund " + sdf.format(entryNarrative.getMinTradeDate()) + "-" + sdf.format(entryNarrative.getMaxTradeDate()));
        fundCashDepositRequest.setLocaleRemark(DateUtil.format(entryNarrative.getMinTradeDate(), "yyyy年MM月") + "-"
                + DateUtil.format(entryNarrative.getMaxTradeDate(), "yyyy年MM月") + "佣金减免 满30减20 ");

        fundCashDepositRequest.setFeeMoneyType(data.getMoneyType());
        fundCashDepositRequest.setBusinessFlagReal(0);
        fundCashDepositRequest.setTheThird("0");
        fundCashDepositRequest.setExStatus("1");
        fundCashDepositRequest.setBankId(SysConfigUtil.getSysConfigValue("MARKET_PACKAGE_HS_BANK_ID", ""));
        fundCashDepositRequest.setBankAccount(SysConfigUtil.getSysConfigValue("MARKET_PACKAGE_HS_BANK", ""));

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
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }
}
