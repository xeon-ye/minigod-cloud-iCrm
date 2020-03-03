package com.minigod.api.ptf.vo.enums;

/**
 * @Title: PermTypeEnum.java
 * @Description: 组合权限枚举类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-12-29 下午23:35:52
 * @version v1.0
 */

public enum PermTypeEnum {
	OWN("仅自己可见", 0), //
	PART("部分人可见", 1), //
	ALL("所有好友可见", 2); //

	private String typeName;
	private Integer typeValue;

	private PermTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (PermTypeEnum permTypeEnum : PermTypeEnum.values()) {
			if (permTypeEnum.getTypeValue().equals(index)) {
				return permTypeEnum.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (PermTypeEnum permTypeEnum : PermTypeEnum.values()) {
			if (permTypeEnum.getTypeValue().equals(index)) {
				return permTypeEnum.getTypeValue();
			}
		}
		return null;
	}
}
