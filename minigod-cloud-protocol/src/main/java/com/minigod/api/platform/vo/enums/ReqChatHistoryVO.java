package com.minigod.api.platform.vo.enums;

import com.minigod.api.user.vo.SNVersion;

public class ReqChatHistoryVO  extends SNVersion {

	private static final long serialVersionUID = 7049754063884151898L;

	private ReqChatHistory params;

	public ReqChatHistory getParams() {
		return params;
	}

	
	
	public void setParams(ReqChatHistory params) {
		this.params = params;
	}

	
}
