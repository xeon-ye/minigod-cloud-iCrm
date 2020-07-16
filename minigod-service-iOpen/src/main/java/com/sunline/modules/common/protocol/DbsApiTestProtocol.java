package com.sunline.modules.common.protocol;

public class DbsApiTestProtocol   {
    private String apiUrl;
    private String sendStr;
    private String key;
    private String business;
    private String msgId;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getSendStr() {
        return sendStr;
    }

    public void setSendStr(String sendStr) {
        this.sendStr = sendStr;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
