/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

public class ReqSetPwdVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private ReqSetPwd  params;

	public ReqSetPwd getParams() {
		return params;
	}

	public void setParams(ReqSetPwd params) {
		this.params = params;
	}	
}
