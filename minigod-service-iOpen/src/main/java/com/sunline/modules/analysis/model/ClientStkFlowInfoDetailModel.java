package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 股份查询导出Excel模板
 * @author: fuyy
 * @date: 2018/11/28
 * @version: v1.0
 */

public class ClientStkFlowInfoDetailModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "小神号" ,index = 1)
    private String userId;

    @ExcelProperty(value = "客户姓名" ,index = 2)
    private String clientName;

    @ExcelProperty(value = "交易帐号" ,index = 3)
    private String clientId;

    @ExcelProperty(value = "资金帐号" ,index = 4)
    private String fundAccount;

    @ExcelProperty(value = "渠道" ,index = 5)
    private String channelId;

    @ExcelProperty(value = "交易日期" ,index = 6)
    private String tradeDate;

    @ExcelProperty(value = "证券市场" ,index = 7)
    private String exchangeType;

    @ExcelProperty(value = "证券代码" ,index = 8)
    private String stockCode;

    @ExcelProperty(value = "证券名称" ,index = 9)
    private String stockName;

    @ExcelProperty(value = "证券类别" ,index = 10)
    private String stockType;

    @ExcelProperty(value = "货币名称" ,index = 11)
    private String moneyType;

    @ExcelProperty(value = "期初数量" ,index = 12)
    private String beginAmount;

    @ExcelProperty(value = "当前数量" ,index = 13)
    private String currentAmount;

    @ExcelProperty(value = "冻结数量" ,index = 14)
    private String frozenAmount;

    @ExcelProperty(value = "解冻数量" ,index = 15)
    private String unfrozenAmount;

    @ExcelProperty(value = "买入均价" ,index = 16)
    private String costPrice;

    @ExcelProperty(value = "证券市值" ,index = 17)
    private String stockMktValue;

    @ExcelProperty(value = "参考盈亏" ,index = 18)
    private String referProfitCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
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

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getBeginAmount() {
        return beginAmount;
    }

    public void setBeginAmount(String beginAmount) {
        this.beginAmount = beginAmount;
    }

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(String frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getUnfrozenAmount() {
        return unfrozenAmount;
    }

    public void setUnfrozenAmount(String unfrozenAmount) {
        this.unfrozenAmount = unfrozenAmount;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getStockMktValue() {
        return stockMktValue;
    }

    public void setStockMktValue(String stockMktValue) {
        this.stockMktValue = stockMktValue;
    }

    public String getReferProfitCost() {
        return referProfitCost;
    }

    public void setReferProfitCost(String referProfitCost) {
        this.referProfitCost = referProfitCost;
    }
}
