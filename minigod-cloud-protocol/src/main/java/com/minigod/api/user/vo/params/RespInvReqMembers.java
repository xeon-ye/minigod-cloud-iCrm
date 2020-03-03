package com.minigod.api.user.vo.params;

import java.io.Serializable;

public class RespInvReqMembers implements Serializable {

	private static final long serialVersionUID = 6072491418919174599L;

	private String name;//名字
	private String phoneNum;//电话号码

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
