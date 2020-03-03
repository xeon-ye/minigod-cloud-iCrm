package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserRegInfo;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class UserRegisterVO extends SNVersion {

	private static final long serialVersionUID = -3594324540170625743L;

	@Emoji
	private UserRegInfo params;

	public UserRegInfo getParams() {
		return params;
	}

	public void setParams(UserRegInfo params) {
		this.params = params;
	}
}
