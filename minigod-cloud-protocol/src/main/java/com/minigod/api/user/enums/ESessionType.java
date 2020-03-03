package com.minigod.api.user.enums;

/**
 * <code>ESessionType</code> 第三方session类型
 *
 * @author Jimmy
 * @date 2015-8-21 下午8:18:09
 * @version v1.0
 */
public enum ESessionType {

	GENERAL("普通会话", 1),
	EXCLUSION("互斥会话", 2);

	private String typeName;
	private Integer typeValue;

	private ESessionType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(ESessionType index) {
		return index.getTypeValue();
	}

	public static String getName(ESessionType index) {
		for (ESessionType c : ESessionType.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (ESessionType c : ESessionType.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
	
	/**
	 * 判断是否为互斥会话
	 * 
	 * @param userType
	 * @return
	 */
	public static boolean isExclusion(Integer userType) {
		if (userType == null) {
			return false;
		}
		return userType.intValue() == ESessionType.EXCLUSION.getTypeValue();
	}
	
	
	/**
	 * 判断是否为普通会话
	 * 
	 * @param userType
	 * @return
	 */
	public static boolean isGeneral(Integer userType) {
		if (userType == null) {
			return false;
		}
		return userType.intValue() == ESessionType.GENERAL.getTypeValue();
	}
}
