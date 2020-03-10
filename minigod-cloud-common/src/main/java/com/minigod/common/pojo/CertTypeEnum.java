package com.minigod.common.pojo;

/**
 * 凭证类型
 */

public enum CertTypeEnum {
    other("其他系统账号", 0),

    // 1-手机
    // 2-邮箱
    // 3-用户账号
    // 4-交易账号
    phone("手机", 1),
    email("邮箱", 2),
    userId("用户号", 3),
    tradeAccount("交易账号", 4),

    // 第三方授权登录
    thirdAccountByWX("微信授权登录", 10),
    thirdAccountByQQ("QQ授权登录", 11),
    thirdAccountByWB("微博授权登录", 12);

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
