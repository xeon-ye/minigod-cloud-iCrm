package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 11:42.
 * minigod
 */
public enum EExchangeType {
    K("HK"),P("US"),D("SH"),H("SZ");
    private final String marketCode ;
    private EExchangeType(String marketCode){
        this.marketCode = marketCode;
    }
    public String getMarketCode(){
        return this.marketCode;
    }
}
