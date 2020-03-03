package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserSwitch   extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;

	private	String  value; //每一位都用Y/N表示是否开通

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
