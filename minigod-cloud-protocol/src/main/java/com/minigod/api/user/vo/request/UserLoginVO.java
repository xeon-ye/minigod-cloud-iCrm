package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.ReqUserInfo;
import com.minigod.api.vo.RequestVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class UserLoginVO  extends SNVersion implements RequestVO {

	private static final long serialVersionUID = 7049754063884151898L;

	@Emoji
	private ReqUserInfo params;

	public ReqUserInfo getParams() {
		return params;
	}

	public void setParams(ReqUserInfo params) {
		this.params = params;
	}
}
