package com.sunline.modules.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 持仓情况
 *
 * @author lcs
 * @date 2018-12-14
 */
public class StockPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 股票名称
     */
    private String stkName;
    /**
     * 股票代码
     */
    private String stkCode;
    /**
     * 浮动盈亏
     */
    private BigDecimal incomeBalance;
    /**
     * 资产ID
     */
    private String assetId;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 市值
     */
    private BigDecimal marketValue;
    /**
     * 当前数量
     */
    private BigDecimal currentAmount;
    /**
     * 保本价
     */
    private BigDecimal keepCostPrice;
    /**
     * 币种
     */
    private String currency;
    /**
     * 可卖数量
     */
    private BigDecimal enableAmount;
    /**
     * 最新价
     */
    private BigDecimal lastPrice;

    /**
     * 成本
     */
    private String totalCost;

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName;
    }

    public BigDecimal getIncomeBalance() {
        return incomeBalance;
    }

    public void setIncomeBalance(BigDecimal incomeBalance) {
        this.incomeBalance = incomeBalance;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getKeepCostPrice() {
        return keepCostPrice;
    }

    public void setKeepCostPrice(BigDecimal keepCostPrice) {
        this.keepCostPrice = keepCostPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getEnableAmount() {
        return enableAmount;
    }

    public void setEnableAmount(BigDecimal enableAmount) {
        this.enableAmount = enableAmount;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getStkCode() {
        return stkCode;
    }

    public void setStkCode(String stkCode) {
        this.stkCode = stkCode;
    }
}
