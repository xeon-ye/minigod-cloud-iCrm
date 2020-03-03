package com.minigod.api.user.vo.request.adviser;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.api.user.vo.SNVersion;

public class MyAdviserListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private SNUserBase params;

	public SNUserBase getParams() {
		return params;
	}

	public void setParams(SNUserBase params) {
		this.params = params;
	}
}
