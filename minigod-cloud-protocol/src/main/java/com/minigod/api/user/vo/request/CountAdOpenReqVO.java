package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.CountAdOpenDetailVO;

/**
 * 获取广告链接
 */

public class CountAdOpenReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private CountAdOpenDetailVO params;

	public CountAdOpenDetailVO getParams() {
		return params;
	}

	public void setParams(CountAdOpenDetailVO params) {
		this.params = params;
	}
}
