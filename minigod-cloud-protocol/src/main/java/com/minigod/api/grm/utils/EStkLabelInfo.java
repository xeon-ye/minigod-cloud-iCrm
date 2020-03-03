package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/7/13 15:40.
 * minigod
 */
public enum EStkLabelInfo {

    US_STOCK_CHINA(100,"中国概念股"),
    US_STOCK_HOT(102,"热门美股"),
    US_STOCK_TECH(101,"科技股");

    private Integer labelCode;
    private String labelName;

    private EStkLabelInfo(Integer labelCode, String labelName){
        this.labelCode = labelCode;
        this.labelName = labelName;
    }

    public Integer getlabelCode(){
        return this.labelCode;
    }

    public String getlabelName() {
        return labelName;
    }
}
