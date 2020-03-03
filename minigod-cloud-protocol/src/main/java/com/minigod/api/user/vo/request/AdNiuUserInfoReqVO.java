/**
 * @Title: AdNiuUserInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-18 下午2:47:42
 * @version v1.0
 */

public class AdNiuUserInfoReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer count;
	private Integer posCode;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPosCode() {
		return posCode;
	}
	public void setPosCode(Integer posCode) {
		this.posCode = posCode;
	}
}
