package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

/**
 * 获取投顾开关值
 */
public class RespAdviserSwitchVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
