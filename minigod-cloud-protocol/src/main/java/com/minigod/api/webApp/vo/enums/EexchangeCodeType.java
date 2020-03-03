/**
 * @Title: EexchangeCodeType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description
 * 
 * @author MiniGod
 * @date 2015-9-15 下午8:46:35
 * @version v1.0
 */

public enum EexchangeCodeType {
	EXCHANGE_CODE_1("沪深主板股", "001"), EXCHANGE_CODE_2("中小板股", "002"), EXCHANGE_CODE_3("创业板股", "003"), EXCHANGE_CODE_4(
			"基金", "004");

	private String typeName;
	private String typeValue;

	private EexchangeCodeType(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public static String getTypeName(String index) {
		for (EexchangeCodeType typeEnum : EexchangeCodeType.values()) {
			if (typeEnum.getTypeValue().equals(index)) {
				return typeEnum.typeName;
			}
		}
		return null;
	}

	public static String getTypeValue(String index) {
		for (EexchangeCodeType typeEnum : EexchangeCodeType.values()) {
			if (typeEnum.getTypeName().equals(index)) {
				return typeEnum.typeValue;
			}
		}
		return null;
	}
}
