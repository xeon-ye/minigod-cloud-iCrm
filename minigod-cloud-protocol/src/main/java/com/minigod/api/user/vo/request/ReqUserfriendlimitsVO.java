package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserFriendLimit;

public class ReqUserfriendlimitsVO extends SNVersion {
	private static final long serialVersionUID = 6256580238395671164L;
	
	private UserFriendLimit params;

	public UserFriendLimit getParams() {
		return params;
	}

	public void setParams(UserFriendLimit params) {
		this.params = params;
	}	
}