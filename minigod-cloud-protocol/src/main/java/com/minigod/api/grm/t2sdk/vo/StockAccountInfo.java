package com.minigod.api.grm.t2sdk.vo;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/5/7 15:57.
 * minigod
 */
public class StockAccountInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String stockAccount;
    private String exchangeType;
    private String holderStatus;

    public String getStockAccount() {
        return stockAccount;
    }

    public void setStockAccount(String stockAccount) {
        this.stockAccount = stockAccount;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getHolderStatus() {
        return holderStatus;
    }

    public void setHolderStatus(String holderStatus) {
        this.holderStatus = holderStatus;
    }

}
