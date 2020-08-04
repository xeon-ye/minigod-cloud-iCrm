package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * @description: 资金冻结协议
 * @author: Larry Lai
 * @date: 2019/4/10 15:15
 * @version: v1.0
 */

public class FundFrozenRequest {

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
     * 资金账号
     */
    @JSONField(name = "fund_account")
    private Integer fundAccount;

    /**
     * 币种类别
     */
    @JSONField(name = "money_type")
    private String moneyType;

    /**
     * 冻结原因（对应字典项编号：1111 ）
     */
    @JSONField(name = "frozen_reason")
    private String frozenReason;

    /**
     * 发生金额
     */
    @JSONField(name = "occur_balance")
    private BigDecimal occurbalance;

    /**
     * 限制有效日期
     */
    @JSONField(name = "valid_date")
    private Integer validDate;

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
     * 强制透支标志 0-不允许强制透支 1-允许强制透支
     */
    @JSONField(name = "overdraft_forced_flag")
    private String overdraftForcedFlag;

    /**
     * 流水号(重复调用校验，为空则不校验)
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * 反向流水标志（0-生成反向流水 1- 不生成反向流程）
     */
    @JSONField(name = "revert_flag")
    private String revertFlag;

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

    public Integer getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(Integer fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getFrozenReason() {
        return frozenReason;
    }

    public void setFrozenReason(String frozenReason) {
        this.frozenReason = frozenReason;
    }

    public BigDecimal getOccurbalance() {
        return occurbalance;
    }

    public void setOccurbalance(BigDecimal occurbalance) {
        this.occurbalance = occurbalance;
    }

    public Integer getValidDate() {
        return validDate;
    }

    public void setValidDate(Integer validDate) {
        this.validDate = validDate;
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

    public String getOverdraftForcedFlag() {
        return overdraftForcedFlag;
    }

    public void setOverdraftForcedFlag(String overdraftForcedFlag) {
        this.overdraftForcedFlag = overdraftForcedFlag;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRevertFlag() {
        return revertFlag;
    }

    public void setRevertFlag(String revertFlag) {
        this.revertFlag = revertFlag;
    }

    public String getLicenseStr() {
        return licenseStr;
    }

    public void setLicenseStr(String licenseStr) {
        this.licenseStr = licenseStr;
    }

}
