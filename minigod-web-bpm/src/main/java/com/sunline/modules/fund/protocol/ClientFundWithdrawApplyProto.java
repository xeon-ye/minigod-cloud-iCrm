package com.sunline.modules.fund.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.math.BigDecimal;

/**
 * @description: 出金申请协议
 * @author: Larry Lai
 * @date: 2019/4/1 17:21
 * @version: v1.0
 */

public class ClientFundWithdrawApplyProto extends BaseParameter {

    private static final long serialVersionUID = -6016628474122917135L;

    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //收款人名称
    private String clientNameSpell;
    //提取方式[0-香港银行卡 1-大陆银行卡]
    private Integer withdrawType;
    //收款银行名称
    private String bankName;
    //收款银行帐户
    private String bankNo;
    //出金银行代码
    private String bankCode;
    //SWIFT代码
    private String swiftCode;
    //联系地址
    private String contactAddress;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //提取金额
    private BigDecimal occurBalance;
    //冻结资金
    private BigDecimal frozenBalance;
    //预约号
    private String applicationId;
    //提取手续费
    private BigDecimal chargeMoney;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public Integer getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Integer withdrawType) {
        this.withdrawType = withdrawType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public BigDecimal getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(BigDecimal occurBalance) {
        this.occurBalance = occurBalance;
    }

    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }
}
