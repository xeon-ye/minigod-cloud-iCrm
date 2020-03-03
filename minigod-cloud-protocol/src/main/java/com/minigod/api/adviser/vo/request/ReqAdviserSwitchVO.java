package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.params.AdviserSwitch;
import com.minigod.api.user.vo.SNVersion;

public class ReqAdviserSwitchVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	private AdviserSwitch params;

	public AdviserSwitch getParams() {
		return params;
	}

	public void setParams(AdviserSwitch params) {
		this.params = params;
	}

	
}
