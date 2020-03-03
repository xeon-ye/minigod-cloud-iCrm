package com.minigod.api.user.vo.response;

import java.io.Serializable;


public class RespUserIconVO implements Serializable {

	private static final long serialVersionUID = 5005339629813023132L;

	private String userIcon; //地址

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	
	public RespUserIconVO() {
		super();
	}

	public RespUserIconVO(String userIcon) {
		this.userIcon = userIcon;
	}
}
