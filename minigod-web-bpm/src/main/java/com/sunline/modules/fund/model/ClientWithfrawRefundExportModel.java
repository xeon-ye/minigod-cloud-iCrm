package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 出金退款审核记录导出excel模板
 * @author: Larry Lai
 * @date: 2019/4/8 10:30
 * @version: v1.0
 */

public class ClientWithfrawRefundExportModel extends BaseRowModel {

    @ExcelProperty(value = {"ACCNT NO.", "ACCNT NO."}, index = 0)
    private String clientId;

    @ExcelProperty(value = {"NAME", "NAME"}, index = 1)
    private String clientNameSpell;

    @ExcelProperty(value = {"CLIENT A/C", "CCY"}, index = 2)
    private String ccy;

    @ExcelProperty(value = {"CLIENT A/C", "DEBIT"}, index = 3)
    private String occurBalance;

    @ExcelProperty(value = {"CLIENT A/C", "CREDIT"}, index = 4)
    private String emptyField1;

    @ExcelProperty(value = {"BANK A/C ", "CCY "}, index = 5)
    private String ccy1;

    @ExcelProperty(value = {"BANK A/C ", " DEBIT "}, index = 6)
    private String frozenBalance;

    @ExcelProperty(value = {"BANK A/C ", "CREDIT "}, index = 7)
    private String emptyField2;

    @ExcelProperty(value = {"CUSTDN", "CUSTDN"}, index = 8)
    private String emptyField3;

    @ExcelProperty(value = {"PARTICULARS", "PARTICULARS"}, index = 9)
    private String particulars;

    @ExcelProperty(value = {"H/T", "CODE"}, index = 10)
    private String emptyField4;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getEmptyField1() {
        return emptyField1;
    }

    public void setEmptyField1(String emptyField1) {
        this.emptyField1 = emptyField1;
    }

    public String getCcy1() {
        return ccy1;
    }

    public void setCcy1(String ccy1) {
        this.ccy1 = ccy1;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getEmptyField2() {
        return emptyField2;
    }

    public void setEmptyField2(String emptyField2) {
        this.emptyField2 = emptyField2;
    }

    public String getEmptyField3() {
        return emptyField3;
    }

    public void setEmptyField3(String emptyField3) {
        this.emptyField3 = emptyField3;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getEmptyField4() {
        return emptyField4;
    }

    public void setEmptyField4(String emptyField4) {
        this.emptyField4 = emptyField4;
    }

}
