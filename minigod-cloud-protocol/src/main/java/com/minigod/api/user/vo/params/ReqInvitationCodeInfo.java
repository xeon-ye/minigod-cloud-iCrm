package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class ReqInvitationCodeInfo extends SNUserBase {
	private static final long serialVersionUID = 1184635263082958082L;
	
	private String invCode;//邀请码

	public String getInvCode() {
		return invCode;
	}

	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}
}