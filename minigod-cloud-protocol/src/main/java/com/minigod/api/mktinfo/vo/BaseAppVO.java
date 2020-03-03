package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class BaseAppVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4259016087774857922L;
	private Integer reqType;
	
	/** 回话ID */
	private String sessionId;
	private Integer sessionUserId; //通过会话找到的用户ID

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
	
	
	public Integer getReqType() {
		return reqType;
	}
	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}

}
