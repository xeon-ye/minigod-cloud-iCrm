package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;


/**
 * 汇丰银行流水解析
 * */
public class HSBCHKBillFlowModel extends BaseRowModel {
    @ExcelProperty(value = {"Acc name"},index = 0)
    private String accName;

    @ExcelProperty(value = {"Account number"},index=1)
    private String accNo;

    @ExcelProperty(value = {"Country"},index=3)
    private String currency;

    @ExcelProperty(value = {"Bank reference"},index=9)
    private String referenceNo;

    @ExcelProperty(value = {"Additional narrative"},index=10)
    private String particulars;

    @ExcelProperty(value = {"Value date (dd/mm/yyyy)"},index=13,format = "dd/mm/yyyy")
    private Date valueDate;

    @ExcelProperty(value = {"Credit amount"},index=14)
    private String creditMount;

    @ExcelProperty(value = {"Time"},index=17)
    private String processingTime;

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getCreditMount() {
        return creditMount;
    }

    public void setCreditMount(String creditMount) {
        this.creditMount = creditMount;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }
}
