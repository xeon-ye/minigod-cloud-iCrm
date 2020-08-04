package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * @description: 现金取协议
 * @author: Larry Lai
 * @date: 2019/4/10 15:15
 * @version: v1.0
 */

public class FundCashFetchRequest {

    /**
     * 输入字符（1）
     */
    @JSONField(name = "action_in")
    private Integer actionIn;

    /**
     * 复核类型（1）
     */
    @JSONField(name = "audit_action")
    private String auditAction;

    /**
     * 客户号
     */
    @JSONField(name = "client_id")
    private String clientId;

    /**
     * 资金账号
     */
    @JSONField(name = "fund_account")
    private Integer fundAccount;

    /**
     * 交易密码（传空）
     */
    @JSONField(name = "password")
    private String password;

    /**
     * 币种类别
     */
    @JSONField(name = "money_type")
    private String moneyType;

    /**
     * 发生金额
     */
    @JSONField(name = "occur_balance")
    private BigDecimal occurbalance;

    /**
     * 备注
     */
    @JSONField(name = "remark")
    private String remark;

    /**
     * 中文备注
     */
    @JSONField(name = "locale_remark")
    private String localeRemark;

    /**
     * 限制有效日期
     */
    @JSONField(name = "value_date")
    private Integer valueDate;

    /**
     * 费用币种类别
     */
    @JSONField(name = "fee_money_type")
    private String feeMoneyType;

    /**
     * 受益人姓名
     */
    @JSONField(name = "payee")
    private String payee;

    /**
     * 实际业务标志（0）
     */
    @JSONField(name = "business_flag_real")
    private Integer businessFlagReal;

    /**
     * 第三方标记 1=第三方（0）
     */
    @JSONField(name = "theThird")
    private String theThird;

    /**
     * 扩展表状态（1）
     */
    @JSONField(name = "ex_status")
    private String exStatus;

    /**
     * 强制透支标志 0-不允许强制透支 1-允许强制透支
     */
    @JSONField(name = "overdraft_forced_flag")
    private String overdraftForcedFlag;

    /**
     * 公司银行代码（不传默认取公司默认银行代码）
     */
    @JSONField(name = "bank_id")
    private String bankId;

    /**
     * 公司银行账号（不传默认取公司默认银行账号）
     */
    @JSONField(name = "bank_account")
    private String bankAccount;

    /**
     * 流水号(重复调用校验，为空则不校验)
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * 安全码
     */
    @JSONField(name = "license_str")
    private String licenseStr;

    public Integer getActionIn() {
        return actionIn;
    }

    public void setActionIn(Integer actionIn) {
        this.actionIn = actionIn;
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(Integer fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public BigDecimal getOccurbalance() {
        return occurbalance;
    }

    public void setOccurbalance(BigDecimal occurbalance) {
        this.occurbalance = occurbalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLocaleRemark() {
        return localeRemark;
    }

    public void setLocaleRemark(String localeRemark) {
        this.localeRemark = localeRemark;
    }

    public Integer getValueDate() {
        return valueDate;
    }

    public void setValueDate(Integer valueDate) {
        this.valueDate = valueDate;
    }

    public String getFeeMoneyType() {
        return feeMoneyType;
    }

    public void setFeeMoneyType(String feeMoneyType) {
        this.feeMoneyType = feeMoneyType;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public Integer getBusinessFlagReal() {
        return businessFlagReal;
    }

    public void setBusinessFlagReal(Integer businessFlagReal) {
        this.businessFlagReal = businessFlagReal;
    }

    public String getTheThird() {
        return theThird;
    }

    public void setTheThird(String theThird) {
        this.theThird = theThird;
    }

    public String getExStatus() {
        return exStatus;
    }

    public void setExStatus(String exStatus) {
        this.exStatus = exStatus;
    }

    public String getOverdraftForcedFlag() {
        return overdraftForcedFlag;
    }

    public void setOverdraftForcedFlag(String overdraftForcedFlag) {
        this.overdraftForcedFlag = overdraftForcedFlag;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getLicenseStr() {
        return licenseStr;
    }

    public void setLicenseStr(String licenseStr) {
        this.licenseStr = licenseStr;
    }

}
