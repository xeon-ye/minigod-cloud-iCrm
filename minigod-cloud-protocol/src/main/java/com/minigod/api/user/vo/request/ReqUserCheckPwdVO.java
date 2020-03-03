/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class ReqUserCheckPwdVO extends SNVersion {

	private static final long serialVersionUID = 7049754063884151898L;

	@Emoji
	private ReqUserCheckPwd params;

	public ReqUserCheckPwd getParams() {
		return params;
	}

	public void setParams(ReqUserCheckPwd params) {
		this.params = params;
	}
}
