/**
 * @Title: AdviserOpenReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description h5投顾开户请求类
 *
 * @author panlz
 * @date 2015-8-8 下午9:15:24
 * @version v1.0
 */
public class AdviserOpenReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId ;//投顾用户id
	
	private String sessionId ;//app内部打开需传sessionId
	
	private String openUrl ;//开户url

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
	
}
