package com.sunline.modules.fund.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * DBS银行流水推送
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-02 16:21:13
 */
public class DbsIccBankFlowEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //流水号
    private String msgId;
    //机构编号
    private String orgId;
    //交易时间
    private Date timeStamp;
    //银行所在国
    private String ctry;
    //付款方式
    private String txnType;
    //客户流水号
    private String customerReference;
    //银行流水号
    private String txnRefId;
    //发起汇款日期
    private Date txnDate;
    //收到汇款日期
    private Date valueDt;
    //收款账户名称
    private String receiveAccName;
    //收款账户号码
    private String receiveAccNo;
    //收款虚拟账户名称
    private String receiveVirtualAccName;
    //收款虚拟账户号码
    private String receiveVirtualAccNo;
    //代理类型
    private String proxyType;
    //代理值
    private String proxyValue;
    //币种
    private String txnCcy;
    //到账金额
    private BigDecimal txnAmt;
    //汇款账户名称
    private String senderAccName;
    //汇款账户号码
    private String senderAccNo;
    //汇款银行ID
    private String senderBankId;
    //汇款银行清算代码
    private String senderBankCode;
    //汇款银行分行代码
    private String senderBranchCode;
    //付款明细说明
    private String paymentDetails;
    //汇款人付款代码
    private String purposeCode;
    //额外细节
    private String addtlInf;

    private Integer isCheck;
    private Integer isApply;
    private Date createTime;
    private Date updateTime;
    private String applicationId;
    private String assignDrafter;

    /**
     * 设置：自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：流水号
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取：流水号
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置：机构编号
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取：机构编号
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置：交易时间
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * 获取：交易时间
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * 设置：银行所在国
     */
    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    /**
     * 获取：银行所在国
     */
    public String getCtry() {
        return ctry;
    }

    /**
     * 设置：付款方式
     */
    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    /**
     * 获取：付款方式
     */
    public String getTxnType() {
        return txnType;
    }

    /**
     * 设置：ICN的CASA信用额引用
     */
    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    /**
     * 获取：ICN的CASA信用额引用
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * 设置：银行流水号
     */
    public void setTxnRefId(String txnRefId) {
        this.txnRefId = txnRefId;
    }

    /**
     * 获取：银行流水号
     */
    public String getTxnRefId() {
        return txnRefId;
    }

    /**
     * 设置：发起汇款日期
     */
    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    /**
     * 获取：发起汇款日期
     */
    public Date getTxnDate() {
        return txnDate;
    }

    /**
     * 设置：收到汇款日期
     */
    public void setValueDt(Date valueDt) {
        this.valueDt = valueDt;
    }

    /**
     * 获取：收到汇款日期
     */
    public Date getValueDt() {
        return valueDt;
    }

    /**
     * 设置：收款账户名称
     */
    public void setReceiveAccName(String receiveAccName) {
        this.receiveAccName = receiveAccName;
    }

    /**
     * 获取：收款账户名称
     */
    public String getReceiveAccName() {
        return receiveAccName;
    }

    /**
     * 设置：收款账户号码
     */
    public void setReceiveAccNo(String receiveAccNo) {
        this.receiveAccNo = receiveAccNo;
    }

    /**
     * 获取：收款账户号码
     */
    public String getReceiveAccNo() {
        return receiveAccNo;
    }

    /**
     * 设置：收款虚拟账户名称
     */
    public void setReceiveVirtualAccName(String receiveVirtualAccName) {
        this.receiveVirtualAccName = receiveVirtualAccName;
    }

    /**
     * 获取：收款虚拟账户名称
     */
    public String getReceiveVirtualAccName() {
        return receiveVirtualAccName;
    }

    /**
     * 设置：收款虚拟账户号码
     */
    public void setReceiveVirtualAccNo(String receiveVirtualAccNo) {
        this.receiveVirtualAccNo = receiveVirtualAccNo;
    }

    /**
     * 获取：收款虚拟账户号码
     */
    public String getReceiveVirtualAccNo() {
        return receiveVirtualAccNo;
    }

    /**
     * 设置：代理类型
     */
    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    /**
     * 获取：代理类型
     */
    public String getProxyType() {
        return proxyType;
    }

    /**
     * 设置：代理值
     */
    public void setProxyValue(String proxyValue) {
        this.proxyValue = proxyValue;
    }

    /**
     * 获取：代理值
     */
    public String getProxyValue() {
        return proxyValue;
    }

    /**
     * 设置：币种
     */
    public void setTxnCcy(String txnCcy) {
        this.txnCcy = txnCcy;
    }

    /**
     * 获取：币种
     */
    public String getTxnCcy() {
        return txnCcy;
    }

    /**
     * 设置：到账金额
     */
    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    /**
     * 获取：到账金额
     */
    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    /**
     * 设置：汇款账户名称
     */
    public void setSenderAccName(String senderAccName) {
        this.senderAccName = senderAccName;
    }

    /**
     * 获取：汇款账户名称
     */
    public String getSenderAccName() {
        return senderAccName;
    }

    /**
     * 设置：汇款账户号码
     */
    public void setSenderAccNo(String senderAccNo) {
        this.senderAccNo = senderAccNo;
    }

    /**
     * 获取：汇款账户号码
     */
    public String getSenderAccNo() {
        return senderAccNo;
    }

    /**
     * 设置：汇款账户号码
     */
    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    /**
     * 获取：汇款账户号码
     */
    public String getSenderBankId() {
        return senderBankId;
    }

    /**
     * 设置：汇款银行清算代码
     */
    public void setSenderBankCode(String senderBankCode) {
        this.senderBankCode = senderBankCode;
    }

    /**
     * 获取：汇款银行清算代码
     */
    public String getSenderBankCode() {
        return senderBankCode;
    }

    /**
     * 设置：汇款银行分行代码
     */
    public void setSenderBranchCode(String senderBranchCode) {
        this.senderBranchCode = senderBranchCode;
    }

    /**
     * 获取：汇款银行分行代码
     */
    public String getSenderBranchCode() {
        return senderBranchCode;
    }

    /**
     * 设置：付款明细说明
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * 获取：付款明细说明
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * 设置：汇款人付款代码
     */
    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    /**
     * 获取：汇款人付款代码
     */
    public String getPurposeCode() {
        return purposeCode;
    }

    /**
     * 设置：额外细节
     */
    public void setAddtlInf(String addtlInf) {
        this.addtlInf = addtlInf;
    }

    /**
     * 获取：额外细节
     */
    public String getAddtlInf() {
        return addtlInf;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsApply() {
        return isApply;
    }

    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getAssignDrafter() {
        return assignDrafter;
    }

    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }
}
