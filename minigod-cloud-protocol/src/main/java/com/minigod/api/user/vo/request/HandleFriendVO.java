package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.HandleFriend;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 处理好友添加请求
 */
@TransferBean
public class HandleFriendVO extends SNVersion {

	private static final long serialVersionUID = -8637537099643800772L;
	
	@TransferID
	public HandleFriend params;

	public HandleFriend getParams() {
		return params;
	}

	public void setParams(HandleFriend params) {
		this.params = params;
	}
}
