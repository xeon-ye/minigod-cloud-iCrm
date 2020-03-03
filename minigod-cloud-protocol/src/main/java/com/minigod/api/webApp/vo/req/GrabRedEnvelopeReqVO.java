/**
 * @Title: GrabRedEnvelopeRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-26 下午2:36:09
 * @version v1.0
 */

public class GrabRedEnvelopeReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer adId;

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
