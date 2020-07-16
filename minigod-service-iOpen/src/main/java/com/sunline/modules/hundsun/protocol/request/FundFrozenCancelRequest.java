package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * @description: 资金解冻协议
 * @author: Larry Lai
 * @date: 2019/4/10 15:15
 * @version: v1.0
 */

public class FundFrozenCancelRequest {

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
     * 资金冻结日期
     */
    @JSONField(name = "jour_date")
    private Integer jourDate;

    /**
     * 资金冻结反向流水号
     */
    @JSONField(name = "jour_serial_no")
    private Integer jourSerialNo;

    /**
     * 解冻金额
     */
    @JSONField(name = "cancel_balance")
    private BigDecimal cancelBalance;

    /**
     * 发生金额，审核界面显示
     */
    @JSONField(name = "occur_balance")
    private BigDecimal occurbalance;

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

    public Integer getJourDate() {
        return jourDate;
    }

    public void setJourDate(Integer jourDate) {
        this.jourDate = jourDate;
    }

    public Integer getJourSerialNo() {
        return jourSerialNo;
    }

    public void setJourSerialNo(Integer jourSerialNo) {
        this.jourSerialNo = jourSerialNo;
    }

    public BigDecimal getCancelBalance() {
        return cancelBalance;
    }

    public void setCancelBalance(BigDecimal cancelBalance) {
        this.cancelBalance = cancelBalance;
    }

    public BigDecimal getOccurbalance() {
        return occurbalance;
    }

    public void setOccurbalance(BigDecimal occurbalance) {
        this.occurbalance = occurbalance;
    }

    public String getLicenseStr() {
        return licenseStr;
    }

    public void setLicenseStr(String licenseStr) {
        this.licenseStr = licenseStr;
    }

}
