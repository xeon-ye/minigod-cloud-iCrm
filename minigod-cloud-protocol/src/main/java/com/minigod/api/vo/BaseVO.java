/*
 * FileName: BaseReqVO.java
 * Copyright: Copyright 2014-10-23 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.vo;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;

/**
 * <code>BaseReqVO<code>请求基础实体类。
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1(2014-10-23)
 * 
 */
public class BaseVO implements Serializable {
	
	private static final long serialVersionUID = -2552342645608541505L;
	/** 回话ID */
	private String sessionId;
	private Integer sessionUserId; //通过会话找到的用户ID

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(Integer sessionUserId) {
		this.sessionUserId = sessionUserId;
	}
}
