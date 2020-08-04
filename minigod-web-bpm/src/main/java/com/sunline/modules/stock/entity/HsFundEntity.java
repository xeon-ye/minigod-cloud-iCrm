package com.sunline.modules.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 资产情况
 * 
 * @author lcs
 * @date 2018-12-14
 */
public class HsFundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 现金
     */
    private BigDecimal currentBalance;
    /**
     * 冻结资金
     */
    private BigDecimal frozenBalance;
    /**
     * IPO可用资金
     */
    private BigDecimal ipoBalance;
    /**
     * 总市值
     */
    private BigDecimal marketValue;
    /**
     * 币种【HKD/CNY/USD】
     */
    private String currency;
    /**
     * 可用资金
     */
    private BigDecimal enableBalance;
    /**
     * 总资产
     */
    private BigDecimal asset;
    /**
     * 可取资金
     */
    private BigDecimal specialFetchBalance;

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public BigDecimal getIpoBalance() {
        return ipoBalance;
    }

    public void setIpoBalance(BigDecimal ipoBalance) {
        this.ipoBalance = ipoBalance;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getEnableBalance() {
        return enableBalance;
    }

    public void setEnableBalance(BigDecimal enableBalance) {
        this.enableBalance = enableBalance;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

    public BigDecimal getSpecialFetchBalance() {
        return specialFetchBalance;
    }

    public void setSpecialFetchBalance(BigDecimal specialFetchBalance) {
        this.specialFetchBalance = specialFetchBalance;
    }

    @Override
    public String toString() {
        return "StockAssetEntity{" +
                "currentBalance=" + currentBalance +
                ", frozenBalance=" + frozenBalance +
                ", ipoBalance=" + ipoBalance +
                ", marketValue=" + marketValue +
                ", currency='" + currency + '\'' +
                ", enableBalance=" + enableBalance +
                ", asset=" + asset +
                '}';
    }
}
