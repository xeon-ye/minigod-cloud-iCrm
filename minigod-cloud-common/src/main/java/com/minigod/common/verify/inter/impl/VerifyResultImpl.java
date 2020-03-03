package com.minigod.common.verify.inter.impl;

import com.minigod.common.ResponseResult;

public class VerifyResultImpl implements ResponseResult {
	public static VerifyResultImpl DEFAULT_SUCCESS = new VerifyResultImpl(true, 0);
	public static VerifyResultImpl DEFAULT_FAILED = new VerifyResultImpl(false, 9999);

	private boolean success;
	private int code;
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public VerifyResultImpl() {
		super();
	}

	public VerifyResultImpl(boolean success, int code) {
		super();
		this.success = success;
		this.code = code;
	}

	public VerifyResultImpl(boolean success, int code, String message) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
	}
}