package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class RespNum implements Serializable {

	private static final long serialVersionUID = 7640749996183893618L;
	private Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public RespNum() {
		super();
	}

	public RespNum(Integer num) {
		super();
		this.num = num;
	}
}
