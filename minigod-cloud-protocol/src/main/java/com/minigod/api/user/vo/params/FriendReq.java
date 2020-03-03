package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class FriendReq extends SNUserBase {

	private static final long serialVersionUID = -5280669463360024084L;

	@Emoji
	private String message;// 请求人姓名

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}