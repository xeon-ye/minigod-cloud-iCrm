package com.minigod.api.im.enums;

/**
 * Created by ChenYouhuo on 2016/6/20.
 */
public enum EGroupType {

    GROUP("群组", "1"), CHATROOM("聊天室", "2"),LIVEROOM("直播室", "3");

    private String typeName;
    private String typeValue;

    private EGroupType(String typeName, String typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return this.typeValue;
    }

    public static String getTypeName(String index) {
        for (EGroupType typeEnum : EGroupType.values()) {
            if (typeEnum.getTypeValue().equals(index)) {
                return typeEnum.typeName;
            }
        }
        return null;
    }

    public static String getTypeValue(String index) {
        for (EGroupType typeEnum : EGroupType.values()) {
            if (typeEnum.getTypeValue().equals(index)) {
                return typeEnum.getTypeValue();
            }
        }
        return null;
    }
}
