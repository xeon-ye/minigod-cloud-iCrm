package com.minigod.api.im.enums;

/**
 * Created by ChenYouhuo on 2016/6/20.
 */
public enum EChatroomKind {

    OFFICIAL("官方", "1"), HKSTOCK("港股", "2"),USASTOCK("美股","3"),CHSTOCK("A股","4");

    private String typeName;
    private String typeValue;

    private EChatroomKind(String typeName, String typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return this.typeValue;
    }

    public static String getTypeName(String index) {
        for (EChatroomKind typeEnum : EChatroomKind.values()) {
            if (typeEnum.getTypeValue().equals(index)) {
                return typeEnum.typeName;
            }
        }
        return null;
    }

    public static String getTypeValue(String index) {
        for (EChatroomKind typeEnum : EChatroomKind.values()) {
            if (typeEnum.getTypeValue().equals(index)) {
                return typeEnum.getTypeValue();
            }
        }
        return null;
    }
}
