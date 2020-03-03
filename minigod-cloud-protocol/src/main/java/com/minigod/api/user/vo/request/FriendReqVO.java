package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.FriendReq;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 发送好友添加请求
 */
@TransferBean
public class FriendReqVO extends SNVersion {

	private static final long serialVersionUID = -8637537099643800772L;
	
	@TransferID
	@Emoji
	public FriendReq params;

	public FriendReq getParams() {
		return params;
	}

	public void setParams(FriendReq params) {
		this.params = params;
	}
}
