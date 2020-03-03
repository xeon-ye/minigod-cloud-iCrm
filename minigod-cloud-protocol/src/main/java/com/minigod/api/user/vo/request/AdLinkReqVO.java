package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.AdLinkDetailVO;

/**
 * 获取广告链接
 */

public class AdLinkReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private AdLinkDetailVO params;

	public AdLinkDetailVO getParams() {
		return params;
	}

	public void setParams(AdLinkDetailVO params) {
		this.params = params;
	}
}
