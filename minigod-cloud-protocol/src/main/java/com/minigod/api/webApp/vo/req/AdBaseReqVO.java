/**
 * @Title: AdBaseReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-29 上午9:02:07
 * @version v1.0
 */

public class AdBaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer adId;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
}
