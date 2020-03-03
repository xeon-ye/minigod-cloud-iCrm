package com.minigod.api.user.enums;

/**
 * 凭证类型
 */

public enum UserStatusTypeEnum {

	// 用户状态 0-停用,1-正常,2-锁定

	disable("停用", 0), enable("正常", 1), lock("锁定", 2);

	private String typeName;
	private Integer typeValue;

	private UserStatusTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(UserStatusTypeEnum index) {
		return index.getTypeValue();
	}

	public static String getName(UserStatusTypeEnum index) {
		for (UserStatusTypeEnum c : UserStatusTypeEnum.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (UserStatusTypeEnum c : UserStatusTypeEnum.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
