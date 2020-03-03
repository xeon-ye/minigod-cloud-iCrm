package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserChannelDto;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class UserChannelVO extends SNVersion {

	private static final long serialVersionUID = -3594324540170625743L;

	@Emoji
	private UserChannelDto params;

	public UserChannelDto getParams() {
		return params;
	}

	public void setParams(UserChannelDto params) {
		this.params = params;
	}
}
