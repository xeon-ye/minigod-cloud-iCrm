package com.sunline.modules.account.online.model;

import java.io.Serializable;

public class SendSMSModel implements Serializable {
    private Integer certType; // 0 手机号 1 邮箱
    private String certCode; // 账号
    private String type; // 验证码类型
    private Integer captchaId;// 验证码事件Id
    private String captcha;// 验证码

    public Integer getCertType() {
        return certType;
    }

    public void setCertType(Integer certType) {
        this.certType = certType;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(Integer captchaId) {
        this.captchaId = captchaId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
