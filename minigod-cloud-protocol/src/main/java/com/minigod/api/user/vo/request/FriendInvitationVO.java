package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.FriendInvitation;

public class FriendInvitationVO extends SNVersion {

	private static final long serialVersionUID = -3747470982718941468L;

	private FriendInvitation params;

	public FriendInvitation getParams() {
		return params;
	}

	public void setParams(FriendInvitation params) {
		this.params = params;
	}
}
