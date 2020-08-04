package com.sunline.modules.fund.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 入金申请协议
 * @author: jim
 * @date: 2019/6/1 17:21
 */
public class ClientFundDepositApplyProto extends BaseParameter {

    private static final long serialVersionUID = -6016628474122917135L;

    //app系统主键码
    private Long appId;
    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //SWIFT代码
    private String swiftCode;
    //入金方式[0-香港银行卡 1-大陆银行卡]
    private Integer depositType;
    //汇款方式[0-未知 1-网银汇款 2-支票汇款 3-FPS]
    private Integer remittanceType;
    //汇款银行代码
    private String depositBankCode;
    //汇款银行
    private String depositBank;
    //汇款账号
    private String depositNo;
    //汇款账户名称
    private String depositAccount;
    //收款银行
    private String benefitBank;
    // 收款银行代码
    private String benefitBankCode;
    //收款账号
    private String benefitNo;
    //收款账户名称
    private String benefitAccount;
    //申请金额
    private BigDecimal depositBalance;
    //联系地址
    private String contactAddress;
    //申请时间
    private String applicationTime;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //入金凭证
    private List<String> depositImage;

    //备注
    private String remark;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取 clientId
     *
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置 clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取 fundAccount
     *
     * @return fundAccount
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置 fundAccount
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取 swiftCode
     *
     * @return swiftCode
     */
    public String getSwiftCode() {
        return swiftCode;
    }

    /**
     * 设置 swiftCode
     */
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    /**
     * 获取 depositType
     *
     * @return depositType
     */
    public Integer getDepositType() {
        return depositType;
    }

    /**
     * 设置 depositType
     */
    public void setDepositType(Integer depositType) {
        this.depositType = depositType;
    }

    /**
     * 获取 remittanceType
     *
     * @return remittanceType
     */
    public Integer getRemittanceType() {
        return remittanceType;
    }

    /**
     * 设置 remittanceType
     */
    public void setRemittanceType(Integer remittanceType) {
        this.remittanceType = remittanceType;
    }

    /**
     * 获取 depositBank
     *
     * @return depositBank
     */
    public String getDepositBank() {
        return depositBank;
    }

    /**
     * 设置 depositBank
     */
    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getDepositBankCode() {
        return depositBankCode;
    }

    public void setDepositBankCode(String depositBankCode) {
        this.depositBankCode = depositBankCode;
    }

    /**
     * 获取 depositNo
     *
     * @return depositNo
     */
    public String getDepositNo() {
        return depositNo;
    }

    /**
     * 设置 depositNo
     */
    public void setDepositNo(String depositNo) {
        this.depositNo = depositNo;
    }

    /**
     * 获取 depositAccount
     *
     * @return depositAccount
     */
    public String getDepositAccount() {
        return depositAccount;
    }

    /**
     * 设置 depositAccount
     */
    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    /**
     * 获取 benefitBank
     *
     * @return benefitBank
     */
    public String getBenefitBank() {
        return benefitBank;
    }

    /**
     * 设置 benefitBank
     */
    public void setBenefitBank(String benefitBank) {
        this.benefitBank = benefitBank;
    }

    public String getBenefitBankCode() {
        return benefitBankCode;
    }

    public void setBenefitBankCode(String benefitBankCode) {
        this.benefitBankCode = benefitBankCode;
    }

    /**
     * 获取 benefitNo
     *
     * @return benefitNo
     */
    public String getBenefitNo() {
        return benefitNo;
    }

    /**
     * 设置 benefitNo
     */
    public void setBenefitNo(String benefitNo) {
        this.benefitNo = benefitNo;
    }

    /**
     * 获取 benefitAccount
     *
     * @return benefitAccount
     */
    public String getBenefitAccount() {
        return benefitAccount;
    }

    /**
     * 设置 benefitAccount
     */
    public void setBenefitAccount(String benefitAccount) {
        this.benefitAccount = benefitAccount;
    }

    /**
     * 获取 depositBalance
     *
     * @return depositBalance
     */
    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    /**
     * 设置 depositBalance
     */
    public void setDepositBalance(BigDecimal depositBalance) {
        this.depositBalance = depositBalance;
    }

    /**
     * 获取 contactAddress
     *
     * @return contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置 contactAddress
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * 获取 applicationTime
     *
     * @return applicationTime
     */
    public String getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置 applicationTime
     */
    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取 moneyType
     *
     * @return moneyType
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置 moneyType
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public List<String> getDepositImage() {
        return depositImage;
    }

    public void setDepositImage(List<String> depositImage) {
        this.depositImage = depositImage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
