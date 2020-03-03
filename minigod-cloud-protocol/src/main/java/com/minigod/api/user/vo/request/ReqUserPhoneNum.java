package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserPhoneNum;

public class ReqUserPhoneNum extends SNVersion {

	private static final long serialVersionUID = 1L;

	private UserPhoneNum params;

	public UserPhoneNum getParams() {
		return params;
	}

	public void setParams(UserPhoneNum params) {
		this.params = params;
	}
}
