package com.sunline.modules.common.protocol;

import java.io.Serializable;

public class BaseProtocol implements Serializable {



    private String  requestSource; //请求来源类型
    private String sessionId; // 会话ID

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
