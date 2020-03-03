package com.minigod.api.adviser.vo.enums;

/**
 * <code>EUserIdType</code> 用户类型
 *
 * @author panlz
 * @date 2015-11-3 下午8:18:09
 * @version v1.0
 */
public enum EUserIdType {
	MiniGod("minigod證券國際用户", 1),
	WEIXIN("微信用户", 2); 

	private String typeName;
	private Integer typeValue;

	private EUserIdType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(EUserIdType index) {
		return index.getTypeValue();
	}

	public static String getName(EUserIdType index) {
		for (EUserIdType c : EUserIdType.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (EUserIdType c : EUserIdType.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
