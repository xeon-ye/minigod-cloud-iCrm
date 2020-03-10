package com.minigod.protocol.account.enums;

/**
 * 凭证类型
 */

public enum PasswordTypeEnum {

    // 0-其他
    // 1-验证码
    // 2-密码

    other("其他", 0),
    captcha("验证码", 1),
    password("密码", 2);

    private String typeName;
    private Integer typeValue;

    private PasswordTypeEnum(String typeName, Integer typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public static Integer getTypeValue(PasswordTypeEnum index) {
        return index.getTypeValue();
    }

    public static boolean isContainCertType(Integer certType) {
        boolean bool = false;
        for (PasswordTypeEnum cert : PasswordTypeEnum.values()) {
            if (certType.equals(cert.getTypeValue())) {
                bool = true;
            }
        }
        return bool;
    }
}
