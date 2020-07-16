package com.sunline.modules.account.online.protocol;

import java.util.Date;

/**
 * @description: CA认证信息
 * @author: Larry Lai
 * @date: 2019/1/17 11:03
 * @version: v1.0
 */

public class CaVerityInfoProtocol {

    // 用户证书主题
    private String caCertDn;
    // 证书序列号
    private String caCertSn;
    // 认证时间
    private Date certTime;

    public String getCaCertDn() {
        return caCertDn;
    }

    public void setCaCertDn(String caCertDn) {
        this.caCertDn = caCertDn;
    }

    public String getCaCertSn() {
        return caCertSn;
    }

    public void setCaCertSn(String caCertSn) {
        this.caCertSn = caCertSn;
    }

    public Date getCertTime() {
        return certTime;
    }

    public void setCertTime(Date certTime) {
        this.certTime = certTime;
    }
}
