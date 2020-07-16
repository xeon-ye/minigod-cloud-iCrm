package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;


/**
 * 星展银行流水解析
 * */
public class DBSBillFlowModel extends BaseRowModel {
    @ExcelProperty(index=0)
    private String date;

    @ExcelProperty(index=1)
    private String valueDate;

    @ExcelProperty(index=2)
    private String  dscription1;

    @ExcelProperty(index=3)
    private String description2;

    @ExcelProperty(index=4)
    private String debit;

    @ExcelProperty(index=5)
    private String credit;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getDscription1() {
        return dscription1;
    }

    public void setDscription1(String dscription1) {
        this.dscription1 = dscription1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
