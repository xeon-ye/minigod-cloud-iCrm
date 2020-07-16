package com.sunline.modules.common.pojo.rest;

import java.io.Serializable;

/**
 * @description: 请求基础实体类
 * @author: Larry Lai
 * @date: 2018/8/16 10:36
 * @version: v1.0
 */

public class BaseParameter implements Serializable {

    private static final long serialVersionUID = -5486921710717030131L;

    private String sessionId;
    /**
     * 通过会话找到的用户ID
     */
    private Integer sessionUserId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSessionUserId() {
        return sessionUserId;
    }

    public void setSessionUserId(Integer sessionUserId) {
        this.sessionUserId = sessionUserId;
    }
}
