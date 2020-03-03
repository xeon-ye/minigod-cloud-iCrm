package com.minigod.api.platform.vo.enums;

import com.minigod.api.user.vo.SNVersion;

public class ReqMsgVO  extends SNVersion {

	private static final long serialVersionUID = 7049754063884151898L;

	private ReqMsg params;

	public ReqMsg getParams() {
		return params;
	}

	public void setParams(ReqMsg params) {
		this.params = params;
	}
	
}
