package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class UserSignautre extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;

	@Emoji
	private String newSignature;//用户签名

	public String getNewSignature() {
		return newSignature;
	}

	public void setNewSignature(String newSignature) {
		this.newSignature = newSignature;
	}
}
