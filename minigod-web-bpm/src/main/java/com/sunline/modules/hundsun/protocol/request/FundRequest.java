package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 资金账户管理请求协议
 * @author: Larry Lai
 * @date: 2018/12/13 15:07
 * @version: v1.0
 */

public class FundRequest {
    /**
     * 客户号
     */
    @JSONField(name = "clientId")
    private String clientId;

    /**
     * 资金帐号
     */
    @JSONField(name = "fundAccount")
    private String fundAccount;

    /**
     * 证券市场[K-港交所 P-美国市场]
     */
    @JSONField(name = "exchangeType")
    private String exchangeType;

    /**
     * 币种[HKD-港币 CNY-人民币 USD-美元]
     */
    @JSONField(name = "currency")
    private String currency;

    /**
     * 股票代码
     */
    @JSONField(name = "assetId")
    private String assetId;


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

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
