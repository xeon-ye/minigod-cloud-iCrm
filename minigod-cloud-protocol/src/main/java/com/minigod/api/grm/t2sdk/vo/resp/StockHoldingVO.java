package com.minigod.api.grm.t2sdk.vo.resp;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/5/27 15:31.
 * minigod
 */
public class StockHoldingVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String exchangeType;
    private String assetId;
    private String stockCode;
    private String stockName;
    private String currentAmount;
    private String costPrice;
    private String enableAmount;
    private String marketValue;
    private String lastPrice;
    private String moneyType;
    private String avBuyPrice;
    private String keepCostPrice;
    private String closePrice;
    private String incomeBalance;
    private String incomeRatio;

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

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getEnableAmount() {
        return enableAmount;
    }

    public void setEnableAmount(String enableAmount) {
        this.enableAmount = enableAmount;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getAvBuyPrice() {
        return avBuyPrice;
    }

    public void setAvBuyPrice(String avBuyPrice) {
        this.avBuyPrice = avBuyPrice;
    }

    public String getKeepCostPrice() {
        return keepCostPrice;
    }

    public void setKeepCostPrice(String keepCostPrice) {
        this.keepCostPrice = keepCostPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getIncomeBalance() {
        return incomeBalance;
    }

    public void setIncomeBalance(String incomeBalance) {
        this.incomeBalance = incomeBalance;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getIncomeRatio() {
        return incomeRatio;
    }

    public void setIncomeRatio(String incomeRatio) {
        this.incomeRatio = incomeRatio;
    }
}
