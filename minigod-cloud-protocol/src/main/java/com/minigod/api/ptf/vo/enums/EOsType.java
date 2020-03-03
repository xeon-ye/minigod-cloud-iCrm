package com.minigod.api.ptf.vo.enums;

/**
 * @Title: EOsType.java
 * @Description: 客户端操作系统类型
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author 余俊斌、许德佑
 * @date 2015-03-10
 * @version v1.0
 */

public enum EOsType {
	Android("安卓系统", 0), //
	iOS("苹果iOS", 1), //
	WP("Windows Phone", 2); //

	private String typeName;
	private Integer typeValue;

	private EOsType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static EOsType valueOf(Integer val) {
		for (EOsType permTypeEnum : EOsType.values()) {
			if (permTypeEnum.getTypeValue().equals(val)) {
				return permTypeEnum;
			}
		}
		return null;
	}
	
}
