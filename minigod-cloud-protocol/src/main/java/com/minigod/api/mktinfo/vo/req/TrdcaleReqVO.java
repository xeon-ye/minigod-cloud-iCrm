/**
 * @Title: StkQuotReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;


public class TrdcaleReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private TrdcaleParamVO params;
	
	public TrdcaleParamVO getParams() {
		return params;
	}

	public void setParams(TrdcaleParamVO params) {
		this.params = params;
	}
	
}
