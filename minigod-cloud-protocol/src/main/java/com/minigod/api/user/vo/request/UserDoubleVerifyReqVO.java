package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

public class UserDoubleVerifyReqVO extends SNVersion{

	private static final long serialVersionUID = 1L;
	
	UserDoubleVerifyVO params;

	public UserDoubleVerifyVO getParams() {
		return params;
	}

	public void setParams(UserDoubleVerifyVO params) {
		this.params = params;
	}
	
}
