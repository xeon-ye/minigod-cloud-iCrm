package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 11:42.
 * minigod
 */
public enum ECurrencyType {
    CNY("CNY"),HKD("HKD"),USD("USD");
    private final String name ;
    private ECurrencyType(String name){
        this.name = name;
    }
    public String getName(){
        return this.name();
    }
}
