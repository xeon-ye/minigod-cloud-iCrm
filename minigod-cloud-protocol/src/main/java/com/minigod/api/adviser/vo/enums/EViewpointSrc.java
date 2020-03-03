/**
 * @Title: EViewpointSrc.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-11 上午9:38:57
 * @version v1.0
 */

public enum EViewpointSrc {
	INDEX("广场首页"),
	LIST("精选列表");

	private String typeName;

	private EViewpointSrc(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public boolean equals(String str) {
		return this.toString().equals(str);
	}
}
