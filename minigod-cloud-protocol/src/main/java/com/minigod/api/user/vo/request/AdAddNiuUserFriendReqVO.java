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

public class AdAddNiuUserFriendReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer tarUserId;
	private Integer adId;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getTarUserId() {
		return tarUserId;
	}
	public void setTarUserId(Integer tarUserId) {
		this.tarUserId = tarUserId;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	
}
