/**
 * @Title: GSbaseReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-14 下午1:34:55
 * @version v1.0
 */

public class GSbaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sessionUserId;

	public Integer getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(Integer sessionUserId) {
		this.sessionUserId = sessionUserId;
	}
}
