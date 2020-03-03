package com.minigod.api.mktmgr.vo.req;

import com.minigod.api.user.vo.SNVersion;

public class ReqPcUserLoginVO  extends SNVersion {

	private static final long serialVersionUID = 7049754063884151898L;

	private ReqPcUserInfo params;

	public ReqPcUserInfo getParams() {
		return params;
	}

	public void setParams(ReqPcUserInfo params) {
		this.params = params;
	}

}
