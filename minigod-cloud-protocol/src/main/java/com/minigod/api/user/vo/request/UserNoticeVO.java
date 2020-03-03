package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserNotice;

/**
 * 获取用户系统通知
 */

public class UserNoticeVO extends SNVersion {

	private static final long serialVersionUID = 6491618651886466377L;

	private UserNotice params;

	public UserNotice getParams() {
		return params;
	}

	public void setParams(UserNotice params) {
		this.params = params;
	}
}
