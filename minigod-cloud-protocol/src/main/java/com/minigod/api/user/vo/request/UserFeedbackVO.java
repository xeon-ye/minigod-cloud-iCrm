package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 用户反馈
 */

@TransferBean
public class UserFeedbackVO extends SNVersion {

	private static final long serialVersionUID = -3023112517700071022L;

	private String sessionId; //会话标示
	
	@Emoji
	private String content;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
