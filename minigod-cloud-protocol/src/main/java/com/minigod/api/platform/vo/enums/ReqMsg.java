package com.minigod.api.platform.vo.enums;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

public class ReqMsg extends BaseVO implements Serializable  {

	private static final long serialVersionUID = 7049754063884151898L;

	private String code;
	private String mobile;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
