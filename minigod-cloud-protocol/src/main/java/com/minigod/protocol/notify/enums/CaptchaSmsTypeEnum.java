package com.minigod.protocol.notify.enums;

import lombok.Getter;

@Getter
public enum CaptchaSmsTypeEnum {
    register("注册", "captchaRegister", "4001", false, true, null),
    resetPassword("重置密码", "captchaResetPassword", "4002", false, true, "登录密码"),
    loginSms("短信登录", "captchaLoginSms", "4003", false, true, null),
    modifyMobile("修改手机号码", "captchaModifyMobile", "4004", true, true, "手机号码"),
    commonly("通用", "commonly", "4005", false, false, "通用不需要校验");

    private String name;
    private String type;
    private String key;
    private Boolean auth; // 是否需要登录
    private Boolean once; // 是否只能使用一次
    private String messageInfo;

    private CaptchaSmsTypeEnum(String name, String type, String key, Boolean auth, Boolean once, String messageInfo) {
        this.name = name;
        this.type = type;
        this.key = key;
        this.auth = auth;
        this.once = once;
        this.messageInfo = messageInfo;
    }

    public static CaptchaSmsTypeEnum getInfo(String index) {
        for (CaptchaSmsTypeEnum c : CaptchaSmsTypeEnum.values()) {
            if (c.getKey().equals(index)) {
                return c;
            }
        }
        return null;
    }
}
