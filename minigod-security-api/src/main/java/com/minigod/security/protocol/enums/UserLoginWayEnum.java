package com.minigod.security.protocol.enums;

/**
 * 凭证类型
 */

public enum UserLoginWayEnum {

    // 0-密码
    // 1-验证码
    // 2-token

    pwd("密码", 0),
    captcha("验证码", 1),
    other("其他校验方式", 2);

    private String typeName;
    private Integer typeValue;

    private UserLoginWayEnum(String typeName, Integer typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public static Integer getTypeValue(UserLoginWayEnum index) {
        return index.getTypeValue();
    }

    public static boolean isContainCertType(Integer certType) {
        boolean bool = false;
        for (UserLoginWayEnum cert : UserLoginWayEnum.values()) {
            if (certType.equals(cert.getTypeValue())) {
                bool = true;
            }
        }
        return bool;
    }
}
