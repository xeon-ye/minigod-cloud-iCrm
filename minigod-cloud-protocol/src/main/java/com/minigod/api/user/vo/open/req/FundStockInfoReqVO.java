package com.minigod.api.user.vo.open.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description:
 * @author: Larry Lai
 * @date: 2017/12/5 0005 下午 4:12
 * @version: v1.0
 */

public class FundStockInfoReqVO extends BaseVO {
    // 资金账号
    private String fundAccount;

    // 交易市场类型[75-港交所 80-美国股市 49-上海A股]
    private Integer exchangeType;

    // 交易日期
    private String trdDate;

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getTrdDate() {
        return trdDate;
    }

    public void setTrdDate(String trdDate) {
        this.trdDate = trdDate;
    }
}
