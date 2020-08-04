package com.sunline.modules.report.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 渠道业绩统计报表导出Excel模板
 * @author: fuyy
 * @date: 2018/11/27 16:33
 * @version: v1.0
 */

public class ChannelPerStatModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "渠道" ,index = 1)
    private String channelId;

    @ExcelProperty(value = "新增用户数" ,index = 2)
    private String addUserQuantity;

    @ExcelProperty(value = "累计用户数" ,index = 3)
    private String totalUserQuantity;

    @ExcelProperty(value = "新增开户数" ,index = 4)
    private String addClientQuantity;

    @ExcelProperty(value = "累计开户数" ,index = 5)
    private String totalClientQuantity;

    @ExcelProperty(value = "新增入金客户数" ,index = 6)
    private String addDepClientQuantity;

    @ExcelProperty(value = "累计入金客户数" ,index = 7)
    private String totalDepClientQuantity;

    @ExcelProperty(value = "新增出金客户数" ,index = 8)
    private String addWitClientQuantity;

    @ExcelProperty(value = "累计出金客户数" ,index = 9)
    private String totalWitClientQuantity;

    @ExcelProperty(value = "新增转仓客户数" ,index = 10)
    private String addStkTranQuantity;

    @ExcelProperty(value = "累计转仓客户数" ,index = 11)
    private String totalStkTranQuantity;

    @ExcelProperty(value = "新增交易客户数" ,index = 12)
    private String addTradeClientQuantity;

    @ExcelProperty(value = "累计交易客户数" ,index = 13)
    private String totalTradeClientQuantity;

    @ExcelProperty(value = "新增入金金额数" ,index = 13)
    private String addIncomeBalance;

    @ExcelProperty(value = "累计入金金额数" ,index = 15)
    private String totalIncomeBalance;

    @ExcelProperty(value = "新增出金金额数" ,index = 16)
    private String addOutBalance;

    @ExcelProperty(value = "累计出金金额数" ,index = 17)
    private String totalOutBalance;

    @ExcelProperty(value = "新增成交数量" ,index = 18)
    private String addTradeAmount;

    @ExcelProperty(value = "累计成交数量" ,index = 19)
    private String totalTradeAmount;

    @ExcelProperty(value = "新增成交金额" ,index = 20)
    private String addTradeBalance;

    @ExcelProperty(value = "累计成交金额" ,index = 21)
    private String totalTradeBalance;

    @ExcelProperty(value = "新增交易佣金" ,index = 22)
    private String addTradeBrokerage;

    @ExcelProperty(value = "累计交易佣金" ,index = 23)
    private String totalTradeBrokerage;

    @ExcelProperty(value = "新增总资产" ,index = 24)
    private String addClientAsset;

    @ExcelProperty(value = "累计总资产" ,index = 25)
    private String totalClientAsset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAddUserQuantity() {
        return addUserQuantity;
    }

    public void setAddUserQuantity(String addUserQuantity) {
        this.addUserQuantity = addUserQuantity;
    }

    public String getTotalUserQuantity() {
        return totalUserQuantity;
    }

    public void setTotalUserQuantity(String totalUserQuantity) {
        this.totalUserQuantity = totalUserQuantity;
    }

    public String getAddClientQuantity() {
        return addClientQuantity;
    }

    public void setAddClientQuantity(String addClientQuantity) {
        this.addClientQuantity = addClientQuantity;
    }

    public String getTotalClientQuantity() {
        return totalClientQuantity;
    }

    public void setTotalClientQuantity(String totalClientQuantity) {
        this.totalClientQuantity = totalClientQuantity;
    }

    public String getAddDepClientQuantity() {
        return addDepClientQuantity;
    }

    public void setAddDepClientQuantity(String addDepClientQuantity) {
        this.addDepClientQuantity = addDepClientQuantity;
    }

    public String getTotalDepClientQuantity() {
        return totalDepClientQuantity;
    }

    public void setTotalDepClientQuantity(String totalDepClientQuantity) {
        this.totalDepClientQuantity = totalDepClientQuantity;
    }

    public String getAddWitClientQuantity() {
        return addWitClientQuantity;
    }

    public void setAddWitClientQuantity(String addWitClientQuantity) {
        this.addWitClientQuantity = addWitClientQuantity;
    }

    public String getTotalWitClientQuantity() {
        return totalWitClientQuantity;
    }

    public void setTotalWitClientQuantity(String totalWitClientQuantity) {
        this.totalWitClientQuantity = totalWitClientQuantity;
    }

    public String getAddStkTranQuantity() {
        return addStkTranQuantity;
    }

    public void setAddStkTranQuantity(String addStkTranQuantity) {
        this.addStkTranQuantity = addStkTranQuantity;
    }

    public String getTotalStkTranQuantity() {
        return totalStkTranQuantity;
    }

    public void setTotalStkTranQuantity(String totalStkTranQuantity) {
        this.totalStkTranQuantity = totalStkTranQuantity;
    }

    public String getAddTradeClientQuantity() {
        return addTradeClientQuantity;
    }

    public void setAddTradeClientQuantity(String addTradeClientQuantity) {
        this.addTradeClientQuantity = addTradeClientQuantity;
    }

    public String getTotalTradeClientQuantity() {
        return totalTradeClientQuantity;
    }

    public void setTotalTradeClientQuantity(String totalTradeClientQuantity) {
        this.totalTradeClientQuantity = totalTradeClientQuantity;
    }

    public String getAddIncomeBalance() {
        return addIncomeBalance;
    }

    public void setAddIncomeBalance(String addIncomeBalance) {
        this.addIncomeBalance = addIncomeBalance;
    }

    public String getTotalIncomeBalance() {
        return totalIncomeBalance;
    }

    public void setTotalIncomeBalance(String totalIncomeBalance) {
        this.totalIncomeBalance = totalIncomeBalance;
    }

    public String getAddOutBalance() {
        return addOutBalance;
    }

    public void setAddOutBalance(String addOutBalance) {
        this.addOutBalance = addOutBalance;
    }

    public String getTotalOutBalance() {
        return totalOutBalance;
    }

    public void setTotalOutBalance(String totalOutBalance) {
        this.totalOutBalance = totalOutBalance;
    }

    public String getAddTradeAmount() {
        return addTradeAmount;
    }

    public void setAddTradeAmount(String addTradeAmount) {
        this.addTradeAmount = addTradeAmount;
    }

    public String getTotalTradeAmount() {
        return totalTradeAmount;
    }

    public void setTotalTradeAmount(String totalTradeAmount) {
        this.totalTradeAmount = totalTradeAmount;
    }

    public String getAddTradeBalance() {
        return addTradeBalance;
    }

    public void setAddTradeBalance(String addTradeBalance) {
        this.addTradeBalance = addTradeBalance;
    }

    public String getTotalTradeBalance() {
        return totalTradeBalance;
    }

    public void setTotalTradeBalance(String totalTradeBalance) {
        this.totalTradeBalance = totalTradeBalance;
    }

    public String getAddTradeBrokerage() {
        return addTradeBrokerage;
    }

    public void setAddTradeBrokerage(String addTradeBrokerage) {
        this.addTradeBrokerage = addTradeBrokerage;
    }

    public String getTotalTradeBrokerage() {
        return totalTradeBrokerage;
    }

    public void setTotalTradeBrokerage(String totalTradeBrokerage) {
        this.totalTradeBrokerage = totalTradeBrokerage;
    }

    public String getAddClientAsset() {
        return addClientAsset;
    }

    public void setAddClientAsset(String addClientAsset) {
        this.addClientAsset = addClientAsset;
    }

    public String getTotalClientAsset() {
        return totalClientAsset;
    }

    public void setTotalClientAsset(String totalClientAsset) {
        this.totalClientAsset = totalClientAsset;
    }
}
