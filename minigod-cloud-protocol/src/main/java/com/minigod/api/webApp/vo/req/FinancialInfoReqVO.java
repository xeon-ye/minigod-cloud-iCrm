/**
 * @Title: FinancialInfoReqVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 理财信息请求类
 *
 * @author minigod
 * @date 2016-1-19 下午3:25:24
 * @version v1.0
 */

public class FinancialInfoReqVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sessionId ;//app内部打开需传sessionId

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
