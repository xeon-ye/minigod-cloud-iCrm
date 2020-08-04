package com.sunline.modules.fund.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 入金银行流水记录表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-11 14:25:39
 */
public class DepositBankBillFlowEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //银行流水号
    private String referenceNo;
    //入金预约流水号
    private String applicationId;
    //发生金额
    private BigDecimal creditAmount;
    //银行名称
    private String bankName;
    //银行账号
    private String accNo;
    //账户名
    private String accName;
    //子账户名
    private String subAccname;
    //子账号
    private String subAccno;
    //币种
    private String currency;
    //发生时间
    private Date valueDate;
    //核对状态[0-未核对 1-已核对]
    private Integer checkStatus;
    //创建人
    private String createUser;
    //更新人
    private String updateUser;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //金额上下限
    private String creditAmountMax;
    private String creditAmountMin;

    private String particulars;

    //是否重复0-未重复 1-重复
    private int repeat;

    //指定处理人
    private String assignDrafter;

    //流水号
    private String msgId;
    //客户流水号
    private String customerReference;
    //交易时间
    private Date timeStamp;
    //交易类型
    private String txnType;
    //汇款账户名称
    private String senderAccName;
    //汇款账户号码
    private String senderAccNo;
    //汇款银行ID
    private String senderBankId;
    //数据来源 [0-人工导入 1-api接入]
    private Integer  flowSource;
    //汇款金额
    private BigDecimal actualMoney;
    //are手续费
    private BigDecimal areChargeMoney;
    //are响应状态:ACSP-查询成功；RJCT-查询失败；PART-查询成功记录超过1000
    private String areEnqStatus;
    //are获取时间
    private Date areTime;
    //银行处理时间
    private String processingTime;



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
     * 设置：银行流水号
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * 获取：银行流水号
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * 设置：入金预约流水号
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取：入金预约流水号
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置：发生金额
     */

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * 获取：发生金额
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * 设置：银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取：银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置：银行账号
     */
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    /**
     * 获取：银行账号
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * 设置：账户名
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }

    /**
     * 获取：账户名
     */
    public String getAccName() {
        return accName;
    }

    /**
     * 设置：子账户名
     */
    public void setSubAccname(String subAccname) {
        this.subAccname = subAccname;
    }

    /**
     * 获取：子账户名
     */
    public String getSubAccname() {
        return subAccname;
    }

    /**
     * 设置：子账号
     */
    public void setSubAccno(String subAccno) {
        this.subAccno = subAccno;
    }

    /**
     * 获取：子账号
     */
    public String getSubAccno() {
        return subAccno;
    }

    /**
     * 设置：币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取：币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置：发生时间
     */
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * 获取：发生时间
     */
    public Date getValueDate() {
        return valueDate;
    }

    /**
     * 设置：核对状态[0-未核对 1-已核对]
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取：核对状态[0-未核对 1-已核对]
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置：创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取：创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置：更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取：更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getCreditAmountMax() {
        return creditAmountMax;
    }

    public void setCreditAmountMax(String creditAmountMax) {
        this.creditAmountMax = creditAmountMax;
    }

    public String getCreditAmountMin() {
        return creditAmountMin;
    }

    public void setCreditAmountMin(String creditAmountMin) {
        this.creditAmountMin = creditAmountMin;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getAssignDrafter() {
        return assignDrafter;
    }

    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getSenderAccName() {
        return senderAccName;
    }

    public void setSenderAccName(String senderAccName) {
        this.senderAccName = senderAccName;
    }

    public String getSenderAccNo() {
        return senderAccNo;
    }

    public void setSenderAccNo(String senderAccNo) {
        this.senderAccNo = senderAccNo;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public Integer getFlowSource() {
        return flowSource;
    }

    public void setFlowSource(Integer flowSource) {
        this.flowSource = flowSource;
    }

    @Override
    public String toString() {
        return "DepositBankBillFlowEntity{" +
                "id=" + id +
                ", referenceNo='" + referenceNo + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", creditMount=" + creditAmount +
                ", bankName='" + bankName + '\'' +
                ", accNo='" + accNo + '\'' +
                ", accName='" + accName + '\'' +
                ", subAccname='" + subAccname + '\'' +
                ", subAccno='" + subAccno + '\'' +
                ", currency='" + currency + '\'' +
                ", valueDate=" + valueDate +
                ", checkStatus=" + checkStatus +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", particulars='" + particulars + '\'' +
                ", repeat='" + repeat + '\'' +
                ", assignDrafter='" + assignDrafter + '\'' +
                '}';
    }


    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public BigDecimal getAreChargeMoney() {
        return areChargeMoney;
    }

    public void setAreChargeMoney(BigDecimal areChargeMoney) {
        this.areChargeMoney = areChargeMoney;
    }

    public String getAreEnqStatus() {
        return areEnqStatus;
    }

    public void setAreEnqStatus(String areEnqStatus) {
        this.areEnqStatus = areEnqStatus;
    }

    public Date getAreTime() {
        return areTime;
    }

    public void setAreTime(Date areTime) {
        this.areTime = areTime;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }
}
