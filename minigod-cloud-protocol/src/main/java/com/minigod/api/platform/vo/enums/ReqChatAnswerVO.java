package com.minigod.api.platform.vo.enums;

import com.minigod.api.user.vo.SNVersion;

public class ReqChatAnswerVO  extends SNVersion {

	private static final long serialVersionUID = 7049754063884151898L;

	private ReqChatAnswer params;

	public ReqChatAnswer getParams() {
		return params;
	}

	public void setParams(ReqChatAnswer params) {
		this.params = params;
	}

	
}
