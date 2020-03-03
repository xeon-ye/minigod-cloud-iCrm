/**
 * @Title: RegSendReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-12-9 下午8:31:20
 * @version v1.0
 */

public class RegSendReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String phoneNum;
	private String eventId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

}
