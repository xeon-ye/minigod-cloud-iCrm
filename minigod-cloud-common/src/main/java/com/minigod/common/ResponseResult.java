package com.minigod.common;

public interface ResponseResult {
	boolean isSuccess();
	String getMessage();
	int getCode();
}