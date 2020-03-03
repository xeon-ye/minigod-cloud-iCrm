package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserPrivacy;

public class ReqUserPrivacyVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	private UserPrivacy params;

	public UserPrivacy getParams() {
		return params;
	}

	public void setParams(UserPrivacy params) {
		this.params = params;
	}

	
}
