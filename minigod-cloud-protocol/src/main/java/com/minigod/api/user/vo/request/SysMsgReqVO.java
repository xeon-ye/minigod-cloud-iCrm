package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.SysMsgDetailVO;

/**
 * 获取用户系统通知
 */

public class SysMsgReqVO extends SNVersion {

	private static final long serialVersionUID = 6491618651886466377L;

	private SysMsgDetailVO params;

	public SysMsgDetailVO getParams() {
		return params;
	}

	public void setParams(SysMsgDetailVO params) {
		this.params = params;
	}
}
