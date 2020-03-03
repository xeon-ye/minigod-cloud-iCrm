package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;

/**
 * 获取开关值
 */
@TransferBean
public class RespUserSwitchVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
