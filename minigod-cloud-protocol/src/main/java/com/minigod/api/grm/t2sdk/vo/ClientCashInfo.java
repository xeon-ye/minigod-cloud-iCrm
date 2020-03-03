package com.minigod.api.grm.t2sdk.vo;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/5/7 16:08.
 * minigod
 */
public class ClientCashInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String moneyType;
    private String enableBalance;
    private String frozenBalance;
    private String marketValue;
    private String asset;
    private String transferBalance;
    private String fetchBalance;
    private String cashOnHold;
    private String maxExposure;
    private String creditLine;
    private String marginValue;
    private String marginCall;
    private String ipoBalance;
    private String incomeBalance;
    private String incomeRatio;
    private String currentBalance;

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getEnableBalance() {
        return enableBalance;
    }

    public void setEnableBalance(String enableBalance) {
        this.enableBalance = enableBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getTransferBalance() {
        return transferBalance;
    }

    public void setTransferBalance(String transferBalance) {
        this.transferBalance = transferBalance;
    }

    public String getFetchBalance() {
        return fetchBalance;
    }

    public void setFetchBalance(String fetchBalance) {
        this.fetchBalance = fetchBalance;
    }

    public String getCashOnHold() {
        return cashOnHold;
    }

    public void setCashOnHold(String cashOnHold) {
        this.cashOnHold = cashOnHold;
    }

    public String getMaxExposure() {
        return maxExposure;
    }

    public void setMaxExposure(String maxExposure) {
        this.maxExposure = maxExposure;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public String getMarginValue() {
        return marginValue;
    }

    public void setMarginValue(String marginValue) {
        this.marginValue = marginValue;
    }

    public String getMarginCall() {
        return marginCall;
    }

    public void setMarginCall(String marginCall) {
        this.marginCall = marginCall;
    }

    public String getIpoBalance() {
        return ipoBalance;
    }

    public void setIpoBalance(String ipoBalance) {
        this.ipoBalance = ipoBalance;
    }

    public String getIncomeBalance() {
        return incomeBalance;
    }

    public void setIncomeBalance(String incomeBalance) {
        this.incomeBalance = incomeBalance;
    }

    public String getIncomeRatio() {
        return incomeRatio;
    }

    public void setIncomeRatio(String incomeRatio) {
        this.incomeRatio = incomeRatio;
    }


    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
}
