package com.minigod.api.user.enums;

/**
 * 凭证类型
 */

public enum CertTypeEnum {

    // 0手机
    // 1邮箱
    // 2-微信minigod證券國際APP openid
    // 3-微博
    // 4-QQ
    // 5-微信unionid
    // 6-微信minigod公众号 openid

    phone("手机", 0), email("邮箱", 1), weixinAppOpenId("微信APP OpenId", 2), weibo("微博", 3), qq("QQ",
            4), weixinUnionid("微信unionid", 5), weixinGZHOpenId("微信公众号 OpenId", 6), trd("交易帐号", 7),
    userCode("犇犇号", 8);

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
