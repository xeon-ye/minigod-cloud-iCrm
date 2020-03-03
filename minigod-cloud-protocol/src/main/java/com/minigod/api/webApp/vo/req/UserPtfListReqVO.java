/**
 * @Title: UserPtfListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author MiniGod
 * @date 2015-7-29 上午10:59:07
 * @version v1.0
 */

public class UserPtfListReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
