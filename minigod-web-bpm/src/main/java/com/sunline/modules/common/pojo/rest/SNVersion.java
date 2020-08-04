package com.sunline.modules.common.pojo.rest;

import java.io.Serializable;

/**
 * @description:
 * @author: Larry Lai
 * @date: 2018/8/16 10:37
 * @version: v1.0
 */

public class SNVersion implements Serializable {
    private static final long serialVersionUID = -8082926869795522051L;

    // 前端请求接口的版本号
    private String version;

    private String sign;//签名

    // 由请求调用者生成的一个请求ID,后端可用于做并发控制，对于同一session是唯一的
    // APP端生成规则：app当前时间的timestamp+6位自增长数字，例如：1425908755444000001，改时间可能重复但风险不大
    private String id;

    // 请求来源,sunline證券國際PC版调用src=PC，APP调用为空（默认APP），WEB调用src=WEB(后续可扩展)
    private String src;
    // 官网用户登录凭证
    private String userToken;

    // 客户端请求ip
    private String ip;
    // 客户端mac
    private String mac;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
