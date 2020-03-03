package com.minigod.api.user.vo.params;

import java.io.Serializable;

public class Captcha implements Serializable {
	private static final long serialVersionUID = -4982455850940414339L;
	
	private Integer nameType;//编号类型  (0 手机号,1userID)
	private String name;//编号(手机号或邮箱地址或userId)

	public Integer getNameType() {
		return nameType;
	}

	public void setNameType(Integer nameType) {
		this.nameType = nameType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}