/**
 * @Title: QuotaNoticeReqVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 额度开关设置类
 *
 * @author minigod
 * @date 2016-1-23 下午4:35:10
 * @version v1.0
 */

public class QuotaNoticeReqVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sessionId ;//app内部打开需传sessionId
	
	private String noticeSwitch; // 设置额度提醒开关

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getNoticeSwitch() {
		return noticeSwitch;
	}

	public void setNoticeSwitch(String noticeSwitch) {
		this.noticeSwitch = noticeSwitch;
	}
	
}
