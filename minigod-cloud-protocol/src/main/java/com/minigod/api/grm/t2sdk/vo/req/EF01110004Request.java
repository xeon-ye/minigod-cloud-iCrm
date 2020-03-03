package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 查账户汇总资金信息
 */
public class EF01110004Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fundAccount;
    private String toMoneyType;
    private String exchangeType;

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getToMoneyType() {
        return toMoneyType;
    }

    public void setToMoneyType(String toMoneyType) {
        this.toMoneyType = toMoneyType;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
}
