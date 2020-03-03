package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.ReqInvitationCodeInfo;

public class ReqInvitationCodeInfoVO extends SNVersion {

	private static final long serialVersionUID = 794966148916719883L;

	private ReqInvitationCodeInfo params;

	public ReqInvitationCodeInfo getParams() {
		return params;
	}

	public void setParams(ReqInvitationCodeInfo params) {
		this.params = params;
	}
}
