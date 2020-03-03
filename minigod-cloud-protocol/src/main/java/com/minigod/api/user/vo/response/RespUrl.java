package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class RespUrl implements Serializable {

	private static final long serialVersionUID = 5146019368404218471L;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RespUrl() {
		super();
	}

	public RespUrl(String url) {
		super();
		this.url = url;
	}
}
