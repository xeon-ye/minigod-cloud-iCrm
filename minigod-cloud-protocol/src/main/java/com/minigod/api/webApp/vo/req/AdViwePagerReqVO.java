/**
 * @Title: AdViwePagerVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-12 上午10:22:30
 * @version v1.0
 */

public class AdViwePagerReqVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ids;
	private String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}