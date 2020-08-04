package com.sunline.modules.fund.helper;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.protocol.DbsApiProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @description: TODO
 * @author: Larry Lai
 * @date: 2020/3/2 17:03
 * @version: v1.0
 */

public class DbsApiHelper {

    private static final Logger logger = LoggerFactory.getLogger(DbsApiHelper.class);

    /**
     * dbs api数据格式转换
     *
     * @param protocol
     * @return
     */
    public static DbsIccBankFlowEntity protocolToEntity(DbsApiProtocol protocol) {
        DbsIccBankFlowEntity dbsIccBankFlowEntity = new DbsIccBankFlowEntity();
        dbsIccBankFlowEntity.setMsgId(protocol.getHeader().getMsgId());
        dbsIccBankFlowEntity.setOrgId(protocol.getHeader().getOrgId());
        dbsIccBankFlowEntity.setTimeStamp(DateUtil.parse(protocol.getHeader().getTimeStamp(), "yyyy-MM-dd'T'HH:mm:ss.SSS"));
        dbsIccBankFlowEntity.setCtry(protocol.getHeader().getCtry());

        dbsIccBankFlowEntity.setTxnType(protocol.getTxnInfo().getTxnType());
        dbsIccBankFlowEntity.setCustomerReference(protocol.getTxnInfo().getCustomerReference());
        dbsIccBankFlowEntity.setTxnRefId(protocol.getTxnInfo().getTxnRefId());
        dbsIccBankFlowEntity.setTxnDate(DateUtil.parse(protocol.getTxnInfo().getTxnDate(), "yyyy-MM-dd"));
        dbsIccBankFlowEntity.setValueDt(DateUtil.parse(protocol.getTxnInfo().getValueDt(), "yyyy-MM-dd"));

        dbsIccBankFlowEntity.setReceiveAccName(protocol.getTxnInfo().getReceivingParty().getName());
        dbsIccBankFlowEntity.setReceiveAccNo(protocol.getTxnInfo().getReceivingParty().getAccountNo());
        dbsIccBankFlowEntity.setReceiveVirtualAccName(protocol.getTxnInfo().getReceivingParty().getVirtualAccountName());
        dbsIccBankFlowEntity.setReceiveVirtualAccNo(protocol.getTxnInfo().getReceivingParty().getVirtualAccountNo());
        dbsIccBankFlowEntity.setProxyType(protocol.getTxnInfo().getReceivingParty().getProxyType());
        dbsIccBankFlowEntity.setProxyValue(protocol.getTxnInfo().getReceivingParty().getProxyValue());

        dbsIccBankFlowEntity.setTxnCcy(protocol.getTxnInfo().getAmtDtls().getTxnCcy());
        dbsIccBankFlowEntity.setTxnAmt(BigDecimal.valueOf(Double.parseDouble(protocol.getTxnInfo().getAmtDtls().getTxnAmt())));

        dbsIccBankFlowEntity.setSenderAccName(protocol.getTxnInfo().getSenderParty().getName());
        dbsIccBankFlowEntity.setSenderAccNo(protocol.getTxnInfo().getSenderParty().getAccountNo());
        dbsIccBankFlowEntity.setSenderBankId(protocol.getTxnInfo().getSenderParty().getSenderBankId());
        dbsIccBankFlowEntity.setSenderBankCode(protocol.getTxnInfo().getSenderParty().getSenderBankCode());
        dbsIccBankFlowEntity.setSenderBranchCode(protocol.getTxnInfo().getSenderParty().getSenderBranchCode());

        dbsIccBankFlowEntity.setPaymentDetails(protocol.getTxnInfo().getRmtInf().getPaymentDetails());
        dbsIccBankFlowEntity.setPurposeCode(protocol.getTxnInfo().getRmtInf().getPurposeCode());
        dbsIccBankFlowEntity.setAddtlInf(protocol.getTxnInfo().getRmtInf().getAddtlInf());

        return dbsIccBankFlowEntity;
    }

}
