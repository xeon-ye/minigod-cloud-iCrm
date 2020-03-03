package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserSwitch;

public class ReqUserSwitchVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	private UserSwitch params;

	public UserSwitch getParams() {
		return params;
	}

	public void setParams(UserSwitch params) {
		this.params = params;
	}

	
}
