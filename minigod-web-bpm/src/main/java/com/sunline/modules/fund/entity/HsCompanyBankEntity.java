package com.sunline.modules.fund.entity;

import java.io.Serializable;


/**
 * 恒生公司银行帐号信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-23 14:13:44
 */
public class HsCompanyBankEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //银行编号
    private String bankId;
    //银行名称
    private String bankName;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //银行帐户
    private String bankAccount;
    //公司代码
    private String companyCode;
    //备注
    private String remark;
    //合同代码
    private String contractRemark;
    //默认标识
    private String defaultFlag;
    //CA默认标识
    private String caDefaultFlag;
    //是否置顶[0-非置顶 1-置顶]
    private int isTop;

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
     * 设置：银行编号
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取：银行编号
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 设置：币种代码[0-人民币 1-美元 2-港币]
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取：币种代码[0-人民币 1-美元 2-港币]
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置：银行帐户
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 获取：银行帐户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置：公司代码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取：公司代码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：合同代码
     */
    public void setContractRemark(String contractRemark) {
        this.contractRemark = contractRemark;
    }

    /**
     * 获取：合同代码
     */
    public String getContractRemark() {
        return contractRemark;
    }

    /**
     * 设置：默认标识
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    /**
     * 获取：默认标识
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置：CA默认标识
     */
    public void setCaDefaultFlag(String caDefaultFlag) {
        this.caDefaultFlag = caDefaultFlag;
    }

    /**
     * 获取：CA默认标识
     */
    public String getCaDefaultFlag() {
        return caDefaultFlag;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }
}
