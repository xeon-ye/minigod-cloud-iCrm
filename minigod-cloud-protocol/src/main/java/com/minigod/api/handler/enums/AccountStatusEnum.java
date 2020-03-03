package com.minigod.api.handler.enums;

/**
 * @Author PENGFENG
 * @Date 2018/3/13 11:24
 * @Description
 */
public enum  AccountStatusEnum {
    ROLL_OVER(0 , "已转仓"),
    DEPOSITED(1 , "已入金"),
    OPEN_ACCOUNT(2 , "已开户"),
    NO_OPEN_ACCOUNT(3 , "未开户");

    private Integer typeCode;
    private String typeValue;

    private AccountStatusEnum(Integer typeCode , String typeValue) {
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
