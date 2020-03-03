/**
 * @Title: NiuLimitNumReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-17 下午6:14:52
 * @version v1.0
 */

public class RedEnvelopeNumReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer posCode;
	private Integer adId;
	
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public Integer getPosCode() {
		return posCode;
	}
	public void setPosCode(Integer posCode) {
		this.posCode = posCode;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
