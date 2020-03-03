/**
 * @Title: FetchLanternInfoReqVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-2-16 下午6:24:33
 * @version v1.0
 */

public class GrantLanternCouponReqVO implements Serializable {
	/** */
	private static final long serialVersionUID = 5754133639090327436L;
	private String sessionId;// app内部打开需传sessionId
	private String reqNo;
	private Integer adId;

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
