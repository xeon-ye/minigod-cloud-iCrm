package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 13:29.
 * 业务标志
 * minigod
 */
public enum EBusinessFlag {

    //资金存
    CASH_DEPOSIT(2001),
    //资金取
    CASH_WITHDRAWAL(2002),
    //支票取
    CHEQUE_TRANSFER_WITHDRAWAL(2404),
    //支票存
    CHEQUE_TRANSFER_DEPOSIT(2405),
    //证券买
    SECURITY_BUY(4002),
    //证券卖
    SECURITY_SELL(4001);

    private int flag;

    private EBusinessFlag(int flag){
        this.flag = flag;
    }

    public int getFlag(){
        return this.flag;
    }

    public String toString(){
        return String.valueOf(this.flag);
    }
}
