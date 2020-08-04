package com.sunline.modules.stock.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 待入账列表导出
 * @author: fu yanyan
 * @date: 2018/11/28 16:33
 * @version: v1.0
 */
public class DonatedStockPrintModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "领取时间" ,index = 1)
    private String receiveTime;

    @ExcelProperty(value = "客户帐号" ,index = 2)
    private String clientId;

    @ExcelProperty(value = "中文名" ,index = 3)
    private String clientName;

    @ExcelProperty(value = "英文名" ,index = 4)
    private String clientNameSpell;

    @ExcelProperty(value = "证券手机号" ,index = 5)
    private String phoneNumber;

    @ExcelProperty(value = "股票代码" ,index = 6)
    private String stockCode;

    @ExcelProperty(value = "股票名称" ,index = 7)
    private String stockName;

    @ExcelProperty(value = "数量" ,index = 8)
    private String stockQuantity;

    @ExcelProperty(value = "打印状态" ,index = 9)
    private String printStatus;

    @ExcelProperty(value = "印花税状态" ,index = 10)
    private String stampDutyStatus;

    @ExcelProperty(value = "入帐状态" ,index = 11)
    private String accountEntryStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public String getStampDutyStatus() {
        return stampDutyStatus;
    }

    public void setStampDutyStatus(String stampDutyStatus) {
        this.stampDutyStatus = stampDutyStatus;
    }

    public String getAccountEntryStatus() {
        return accountEntryStatus;
    }

    public void setAccountEntryStatus(String accountEntryStatus) {
        this.accountEntryStatus = accountEntryStatus;
    }
}
