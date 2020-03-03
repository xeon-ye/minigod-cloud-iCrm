package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 11:42.
 * minigod
 */
public enum EBoardType {
    STOCK(1),FUND(3),BOND(2),WARRANT(4),INDEX(5),BUYBACK(6);
    private final int no;
    private EBoardType(int no){
        this.no = no;
    }
    public int getNo(){
        return this.no;
    }
}
