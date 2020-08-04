package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 出金记录导出excel模板
 * @author: Larry Lai
 * @date: 2019/4/8 10:30
 * @version: v1.0
 */

public class ClientFundWithdrawApplyModel extends BaseRowModel {

    @ExcelProperty(value = "申请时间", index = 0)
    private String createTime;

    @ExcelProperty(value = "小神号", index = 1)
    private String userId;

    @ExcelProperty(value = "客户帐号", index = 2)
    private String clientId;

    @ExcelProperty(value = "资金帐号", index = 3)
    private String fundAccount;

    @ExcelProperty(value = "客户姓名", index = 4)
    private String clientName;

    @ExcelProperty(value = "英文名", index = 5)
    private String clientNameSpell;

    @ExcelProperty(value = "性别", index = 6)
    private String sex;

    @ExcelProperty(value = "证券手机号码", index = 7)
    private String phoneNumber;

    @ExcelProperty(value = "币种", index = 8)
    private String moneyType;

    @ExcelProperty(value = "提取金额", index = 9)
    private String occurBalance;

    @ExcelProperty(value = "手续费", index = 10)
    private String chargeMoney;

    @ExcelProperty(value = "实际提取金额", index = 11)
    private String actualBalance;

    @ExcelProperty(value = "银行名称", index = 12)
    private String bankName;

    @ExcelProperty(value = "渠道", index = 13)
    private String sourceChannelId;

    @ExcelProperty(value = "状态", index = 14)
    private String applicationStatus;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(String chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public String getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(String actualBalance) {
        this.actualBalance = actualBalance;
    }
}
