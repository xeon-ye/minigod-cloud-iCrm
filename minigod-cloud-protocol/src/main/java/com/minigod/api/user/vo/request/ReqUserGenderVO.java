package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserGender;

public class ReqUserGenderVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	private UserGender params;

	public UserGender getParams() {
		return params;
	}

	public void setParams(UserGender params) {
		this.params = params;
	}
}
