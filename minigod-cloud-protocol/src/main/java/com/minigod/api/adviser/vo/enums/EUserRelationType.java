/**
 * @Title: EUserRelationType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-27 下午4:38:06
 * @version v1.0
 */

public enum EUserRelationType {
	F("好友关系"), C("客户关系"), S("陌生人关系"), M("自己");

	private String typeName;

	private EUserRelationType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
