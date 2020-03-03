/**
 * @Title: AdInvestmentAdviserReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @description 投顾活动信息请求值对象
 * 
 * @author minigod
 * @date 2015-7-21 上午11:12:16
 * @version v1.0
 */

public class AdInvestmentAdviserReqVO implements Serializable {

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
