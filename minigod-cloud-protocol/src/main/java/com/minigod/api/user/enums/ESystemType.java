package com.minigod.api.user.enums;

/**
 * @author kouyandong
 * @version v1.0
 * @description
 * @date 2016/4/6
 */
public enum ESystemType {
    SNS("社区", "SNS"),
    SIMULATE("模拟炒股", "SIMULATE"),
    TDX("金阳光V6", "TDX"),
    BCAPP("掌上霸财APP", "BCAPP"),
    BCiWEB("iWEB网站", "BCiWEB"),
    TSCI("捷利环球快车", "TSCI");
    private String typeName;
    private String typeValue;

    private ESystemType(String typeName, String typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return this.typeValue;
    }

    public static String getTypeValue(ESystemType index) {
        return index.getTypeValue();
    }

    public static String getName(ESystemType index) {
        for (ESystemType c : ESystemType.values()) {
            if (c.getTypeValue().equals(index.getTypeValue())) {
                return c.typeName;
            }
        }
        return null;
    }

    public static String getName(String index) {
        for (ESystemType c : ESystemType.values()) {
            if (c.getTypeValue().equals(index)) {
                return c.typeName;
            }
        }
        return null;
    }

}
