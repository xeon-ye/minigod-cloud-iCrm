/**
 * @Title: EPayTargetType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-30 下午2:58:52
 * @version v1.0
 */

public enum EPayTargetType {
	GROUP(0, "直播群ID"),
	VIEWPOINT(1, "观点的ID");
	
	private int code;
	private String value;
	
	private EPayTargetType(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
