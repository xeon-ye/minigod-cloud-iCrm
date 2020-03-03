package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 返回和请求的基础类
 */
@TransferBean
public class UserBaseVO extends SNVersion {

	private static final long serialVersionUID = 4926141855371145977L;
	
	@TransferID
	@Emoji
	private SNUserBase params;

	public SNUserBase getParams() {
		return params;
	}

	public void setParams(SNUserBase params) {
		this.params = params;
	}
}
