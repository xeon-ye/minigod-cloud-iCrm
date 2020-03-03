/**
 * @Title: EUserRelation.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-4 下午3:25:48
 * @version v1.0
 */

public enum EUserRelation {
	A("A"), // 我的投顾
	C("C"), // 我的客户
	F("F");// 我的好友

	private String typeValue;

	private EUserRelation(String typeValue) {
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
