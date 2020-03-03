package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 11:42.
 * 证券分类
 * minigod
 */
public enum EStkType {
    STOCK(1),FUND(3),BOND(2),WARRANT(4),INDEX(5),CBBC(6)/*,DEBT(7)*/;
    private final int no;
    private EStkType(int no){
        this.no = no;
    }
    public int getNo(){
        return this.no;
    }
}
