package com.minigod.common.pojo;

/**
 * 凭证类型
 */

public enum CertTypeEnum {

    // 0-手机
    // 1-邮箱
    // 2-用户账号
    // 3-session

    phone("手机", 0),
    email("邮箱", 1),
    userId("用户号", 2),
    session("session", 3);

    private String typeName;
    private Integer typeValue;

    private CertTypeEnum(String typeName, Integer typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public static Integer getTypeValue(CertTypeEnum index) {
        return index.getTypeValue();
    }

    public static String getName(CertTypeEnum index) {
        for (CertTypeEnum c : CertTypeEnum.values()) {
            if (c.getTypeValue().equals(index.getTypeValue())) {
                return c.typeName;
            }
        }
        return null;
    }

    public static String getName(Integer index) {
        for (CertTypeEnum c : CertTypeEnum.values()) {
            if (c.getTypeValue().equals(index)) {
                return c.typeName;
            }
        }
        return null;
    }

    public static boolean isContainCertType(Integer certType) {
        boolean bool = false;
        for (CertTypeEnum cert : CertTypeEnum.values()) {
            if (certType.equals(cert.getTypeValue())) {
                bool = true;
            }
        }
        return bool;
    }
}
