package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

public class WeiXin implements Serializable {

	private static final long serialVersionUID = -1543247931592893262L;

	private Integer errcode;
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
