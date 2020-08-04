package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 出金审核记录导出excel模板
 * @author: Larry Lai
 * @date: 2019/4/8 10:30
 * @version: v1.0
 */

public class ClientFundWithdrawApplyAuditModel extends BaseRowModel {

    @ExcelProperty(value = "申请时间", index = 0)
    private String createTime;

    @ExcelProperty(value = "客户帐号", index = 1)
    private String clientId;

    @ExcelProperty(value = "资金帐号", index = 2)
    private String fundAccount;

    @ExcelProperty(value = "英文名", index = 3)
    private String clientName;

    @ExcelProperty(value = "客户姓名", index = 4)
    private String clientNameSpell;

    @ExcelProperty(value = "币种", index = 5)
    private String moneyType;

    @ExcelProperty(value = "冻结金额", index = 6)
    private String frozenBalance;

    @ExcelProperty(value = "提取方式", index = 7)
    private String withdrawType;

    @ExcelProperty(value = "银行名称", index = 8)
    private String bankName;

    @ExcelProperty(value = "银行帐户", index = 9)
    private String bankNo;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(String withdrawType) {
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
}
