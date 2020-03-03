/**
 * @Title: EOrderDirection.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 委托属性枚举类
 *
 * @author minigod
 * @date 2015-3-12 下午3:11:38
 * @version v1.0
 */

public enum ERealPtfOrderActionType {
	F("首次买入");

	private String typeName;

	private ERealPtfOrderActionType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
}
