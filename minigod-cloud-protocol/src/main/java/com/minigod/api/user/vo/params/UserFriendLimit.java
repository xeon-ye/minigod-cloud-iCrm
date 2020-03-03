package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserFriendLimit extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private  Integer friendLimit ;

	public Integer getFriendLimit() {
		return friendLimit;
	}

	public void setFriendLimit(Integer friendLimit) {
		this.friendLimit = friendLimit;
	}
	
	
	
}
