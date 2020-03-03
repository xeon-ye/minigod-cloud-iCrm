package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class RespImageVO implements Serializable {

	private static final long serialVersionUID = 5005339629813023132L;

	private String url; //地址

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RespImageVO() {
		super();
	}

	public RespImageVO(String url) {
		super();
		this.url = url;
	}
}
