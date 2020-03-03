/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class ReqTrdAccountVO extends SNVersion {
	private static final long serialVersionUID = -6163187304722218665L;

	private ReqTrdAccount params;

	public ReqTrdAccount getParams() {
		return params;
	}

	public void setParams(ReqTrdAccount params) {
		this.params = params;
	}

}
