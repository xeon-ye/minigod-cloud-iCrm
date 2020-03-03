package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/7/13 15:40.
 * minigod
 */
public enum ESubStkLabelInfo {

    US_STOCK_CHINA("US0101","中国概念股"),
    US_STOCK_HOT("US0201","热门美股"),
    US_STOCK_TECH("US0301","科技股");

    private String subInduCode;
    private String subInduName;

    private ESubStkLabelInfo(String subInduCode, String subInduName){
        this.subInduCode = subInduCode;
        this.subInduName = subInduName;
    }

    public String getSubInduCode() {
        return subInduCode;
    }

    public String getSubInduName() {
        return subInduName;
    }
}
