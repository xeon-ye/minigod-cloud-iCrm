package com.minigod.api.user.vo.request;

import java.io.Serializable;

public class UserIconVO implements Serializable {

	private static final long serialVersionUID = 5005339629813023132L;

	private String sessionId; //会话标示

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
