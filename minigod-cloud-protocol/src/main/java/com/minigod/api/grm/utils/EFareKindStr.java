package com.minigod.api.grm.utils;

import com.minigod.api.grm.utils.FareKindStr;

/**
 * Created by CaiJianbo on 2016/8/25 16:17.
 * minigod
 */
public enum  EFareKindStr {
    DEFAULT(new FareKindStr("9999","1111")),
    NO_FARE(new FareKindStr("9999","9999"));

    private FareKindStr fareKindStr;

    private EFareKindStr(FareKindStr fareKindStr){
        this.fareKindStr = fareKindStr;
    }

    public FareKindStr getFareKindStr() {
        return fareKindStr;
    }

    public void setFareKindStr(FareKindStr fareKindStr) {
        this.fareKindStr = fareKindStr;
    }
}
