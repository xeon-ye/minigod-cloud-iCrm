package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 交易查询导出Excel模板
 * @author: Larry Lai
 * @date: 2018/11/27 16:33
 * @version: v1.0
 */

public class ClientTrdFlowInfoDetailModel extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 0)
    private String id;

    @ExcelProperty(value = "小神号", index = 1)
    private String userId;

    @ExcelProperty(value = "客户姓名", index = 2)
    private String clientName;

    @ExcelProperty(value = "交易帐号", index = 3)
    private String clientId;

    @ExcelProperty(value = "资金帐号", index = 4)
    private String fundAccount;

    @ExcelProperty(value = "渠道", index = 5)
    private String channelId;

    @ExcelProperty(value = "交易日期", index = 6)
    private String tradeDate;

    @ExcelProperty(value = "证券市场", index = 7)
    private String exchangeType;

    @ExcelProperty(value = "证券代码", index = 8)
    private String stockCode;

    @ExcelProperty(value = "证券名称", index = 9)
    private String stockName;

    @ExcelProperty(value = "证券类别", index = 10)
    private String stockType;

    @ExcelProperty(value = "交易类别", index = 11)
    private String tradeKind;

    @ExcelProperty(value = "委托方式", index = 12)
    private String entrustWay;

    @ExcelProperty(value = "货币名称", index = 13)
    private String moneyType;

    @ExcelProperty(value = "成交数量", index = 14)
    private String businessAmount;

    @ExcelProperty(value = "成交金额", index = 15)
    private String businessBalance;

    @ExcelProperty(value = "成交价格", index = 16)
    private String businessPrice;

    @ExcelProperty(value = "清算金额", index = 17)
    private String occurBalance;

    @ExcelProperty(value = "佣金", index = 18)
    private String feeCount;

    @ExcelProperty(value = "净佣金", index = 19)
    private String profitFeeCount;

    @ExcelProperty(value = "REFUND", index = 20)
    private String refund;

    @ExcelProperty(value = "佣金比例(%)", index = 21)
    private String feeCountRatio;

    @ExcelProperty(value = "交易流水号", index = 22)
    private String sequenceNo;

    public String getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(String businessPrice) {
        this.businessPrice = businessPrice;
    }

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

    public String getTradeKind() {
        return tradeKind;
    }

    public void setTradeKind(String tradeKind) {
        this.tradeKind = tradeKind;
    }

    public String getEntrustWay() {
        return entrustWay;
    }

    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getBusinessAmount() {
        return businessAmount;
    }

    public void setBusinessAmount(String businessAmount) {
        this.businessAmount = businessAmount;
    }

    public String getBusinessBalance() {
        return businessBalance;
    }

    public void setBusinessBalance(String businessBalance) {
        this.businessBalance = businessBalance;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getFeeCount() {
        return feeCount;
    }

    public void setFeeCount(String feeCount) {
        this.feeCount = feeCount;
    }

    public String getProfitFeeCount() {
        return profitFeeCount;
    }

    public void setProfitFeeCount(String profitFeeCount) {
        this.profitFeeCount = profitFeeCount;
    }

    public String getFeeCountRatio() {
        return feeCountRatio;
    }

    public void setFeeCountRatio(String feeCountRatio) {
        this.feeCountRatio = feeCountRatio;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }
}
