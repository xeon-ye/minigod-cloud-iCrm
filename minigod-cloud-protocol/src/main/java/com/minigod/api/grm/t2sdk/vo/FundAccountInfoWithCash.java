package com.minigod.api.grm.t2sdk.vo;

import com.minigod.api.grm.t2sdk.vo.FundAccountInfo;
import com.minigod.api.grm.t2sdk.vo.StockAccountInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CaiJianbo on 2016/5/7 15:47.
 * minigod
 */
public class FundAccountInfoWithCash extends FundAccountInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<StockAccountInfo> stkAccts;
    private List<ClientCashInfo> cashInfos;
    private ClientCashSumInfo cashSumInfo;

    public List<StockAccountInfo> getStkAccts() {
        return stkAccts;
    }

    public void setStkAccts(List<StockAccountInfo> stkAccts) {
        this.stkAccts = stkAccts;
    }

    public List<ClientCashInfo> getCashInfos() {
        return cashInfos;
    }

    public void setCashInfos(List<ClientCashInfo> cashInfos) {
        this.cashInfos = cashInfos;
    }

    public ClientCashSumInfo getCashSumInfo() {
        return cashSumInfo;
    }

    public void setCashSumInfo(ClientCashSumInfo cashSumInfo) {

        this.cashSumInfo = cashSumInfo;
    }

}
