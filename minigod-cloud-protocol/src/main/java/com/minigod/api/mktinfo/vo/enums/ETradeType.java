package com.minigod.api.mktinfo.vo.enums;

/**
 * Created by CaiJianbo on 2016/5/9 19:46.
 * minigod
 */
public enum ETradeType {
    //碎股成交
    ODD_LOT_TRANSACTION("D"),
    //非自动对盘或特别买卖单位的非两边客成交
    NON_DIRECT_TRANSACTION("M"),
    //开市前成交（指交易在开市前已达成，其中包括在上个交易日收市前达成而未及输入系统的成交
    PRE_OPEN_TRANSACTION_("P"),
    //竞价成交
    AUCTION_TRANSACTION("U"),
    //非自动对盘或特别买卖单位的两边客成交
    DIRECT_TRANSACTION("X"),
    //自动对盘的两边客成交
    AUTOMATCH_DIRECT_TRANSACTION("Y"),
    //自动对盘的非两边客成交
    AUTOMATCH_NON_DIRECT_TRANSACTION(" "),
    //成交已遭反驳/取消
    REJECTED_OR_CANCELLED_TRANSACTION("*"),
    //无成类型
    NONE("");
    private String type;
    private ETradeType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
