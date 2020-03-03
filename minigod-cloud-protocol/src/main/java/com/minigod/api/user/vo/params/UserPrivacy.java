package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserPrivacy extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;

	private	String  prvy; //每一位都用Y/N表示是否开通

	public String getPrvy() {
		return prvy;
	}

	public void setPrvy(String prvy) {
		this.prvy = prvy;
	}
}
