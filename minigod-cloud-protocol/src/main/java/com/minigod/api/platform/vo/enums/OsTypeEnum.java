package com.minigod.api.platform.vo.enums;

/**
 * @Title: OsTypeEnum.java
 * @Description: 设备操作系统类型
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-12-29 下午4:27:52
 * @version v1.0
 */

public enum OsTypeEnum {
	OS_ANDROID("安卓系统", 0), //
	OS_IOS("IOS系统", 1), //
	OS_WP("WP系统", 2), //
	OS_ALL("全部", 3),
	OS_OTHER("其他", 4); //
	
	private String typeName;
	private Integer typeValue;

	private OsTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (OsTypeEnum osTypeEnum : OsTypeEnum.values()) {
			if (osTypeEnum.getTypeValue().equals(index)) {
				return osTypeEnum.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (OsTypeEnum osTypeEnum : OsTypeEnum.values()) {
			if (osTypeEnum.getTypeValue().equals(index)) {
				return osTypeEnum.getTypeValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getTypeName(3));
	}
}
