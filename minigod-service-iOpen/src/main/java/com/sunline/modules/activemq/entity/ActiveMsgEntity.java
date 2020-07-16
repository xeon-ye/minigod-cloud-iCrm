package com.sunline.modules.activemq.entity;

import java.io.Serializable;

public class ActiveMsgEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 发送业务名
    private String bizCode;

    // 发送模式[1-queue 2-topic] topic模式需要开启设置
    private int publishType;

    // 消息类型[1-普通消息 2-扩展对象消息]
    private int msgType;

    // 普通消息
    private String msg;

    // 扩展消息
    private T message;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public int getPublishType() {
        return publishType;
    }

    public void setPublishType(int publishType) {
        this.publishType = publishType;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
