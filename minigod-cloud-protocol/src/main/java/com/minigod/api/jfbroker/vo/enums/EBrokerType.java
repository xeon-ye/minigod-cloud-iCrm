package com.minigod.api.jfbroker.vo.enums;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 10:55 2017/9/4
 * @Modified By:
 */
public enum  EBrokerType {

    LC_STOCK_TARGAT(1,"联储证券");

    private Integer typeValue;
    private String typeName;

    private EBrokerType(Integer typeValue, String typeName) {
        this.typeValue = typeValue;
        this.typeName = typeName;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static EBrokerType findByTypeValue(Integer val) {
        for (EBrokerType eBrokerType : EBrokerType.values()) {
            if (eBrokerType.typeValue.equals(val)) {
                return eBrokerType;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(EBrokerType.findByTypeValue(1).getTypeName());
    }

}
