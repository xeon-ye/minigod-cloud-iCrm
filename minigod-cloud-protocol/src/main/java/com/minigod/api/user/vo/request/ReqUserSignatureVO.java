package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserSignautre;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class ReqUserSignatureVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	@Emoji
	private UserSignautre params;

	public UserSignautre getParams() {
		return params;
	}

	public void setParams(UserSignautre params) {
		this.params = params;
	}
}
