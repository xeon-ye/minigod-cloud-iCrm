package com.minigod.api.user.vo.params;


import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 用户反馈,APP内部调用，非h5和web,包括图片的保存
 */

@TransferBean
public class Feedback extends SNUserBase {

	private static final long serialVersionUID = 1728850520889915289L;

	private String sessionId; //会话标示
	
	@Emoji
	private String content;//反馈内容
	private String[] urls; //  图片的URL

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

	public String[] getUrls() {
		return urls;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}
}
