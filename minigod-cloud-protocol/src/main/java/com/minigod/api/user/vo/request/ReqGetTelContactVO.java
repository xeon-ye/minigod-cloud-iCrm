package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserTelContact;

public class ReqGetTelContactVO extends SNVersion {

	private static final long serialVersionUID = 796010654583927455L;
	
	private UserTelContact params;

	public UserTelContact getParams() {
		return params;
	}

	public void setParams(UserTelContact params) {
		this.params = params;
	}
}
