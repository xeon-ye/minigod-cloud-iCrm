package com.minigod.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class CharsetUtil {
	
	public static final String decode(String value) {
		if (value == null || value.trim().length() == 0) {
			return null;
		}
		value = value.trim();
		try {
			return URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException",e);
		}
	}
	
	/**
	 * 中文的转码
	 * @param value
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final String encode(String value) {
		if (value == null || value.trim().length() == 0) {
			return null;
		}
		try {
			return new String(value.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException",e);
		}
	}

	public static final Integer getIntParam(String value) {
		if (value == null) {
			return null;
		}
		if (value.trim().length() == 0) {
			return null;
		}
		try {
			Integer intVal = Integer.parseInt(value);
			return intVal;
		} catch (NumberFormatException e) {
			throw new RuntimeException(value + "不是一个数字.");
		}
	}
	
	public static final Boolean getBooleanParam(final String value) {
		if (value == null) {
			return false;
		}
		if (value.trim().length() == 0) {
			return false;
		}
		try {
			if ("1".equals(value.trim())) {
				return true;
			}
			return Boolean.parseBoolean(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException(value + "不是一个数字.");
		}
	}
}
