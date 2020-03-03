package com.minigod.api.user.enums;

/**
 * 投顾类型
 */

public enum EAdviserType {

	ADVISER("投资顾问", 1), ANALYST("分析师", 2), INVEST_TARENTO("投资达人", 3), FUND("投资达人基金执业资格", 4);

	private String typeName;
	private Integer typeValue;

	private EAdviserType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static String getTypeName(Integer index) {
		for (EAdviserType typeEnum : EAdviserType.values()) {
			if (typeEnum.getTypeValue().equals(index)) {
				return typeEnum.typeName;
			}
		}
		return null;
	}

	public static Integer getTypeValue(Integer index) {
		for (EAdviserType typeEnum : EAdviserType.values()) {
			if (typeEnum.getTypeValue().equals(index)) {
				return typeEnum.getTypeValue();
			}
		}
		return null;
	}
}
