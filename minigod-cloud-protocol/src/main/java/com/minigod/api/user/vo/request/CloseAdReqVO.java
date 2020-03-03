package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.CloseAdDetailVO;

/**
 * 获取广告链接
 */

public class CloseAdReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private CloseAdDetailVO params;

	public CloseAdDetailVO getParams() {
		return params;
	}

	public void setParams(CloseAdDetailVO params) {
		this.params = params;
	}
}
