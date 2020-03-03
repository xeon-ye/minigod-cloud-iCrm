package com.minigod.api.platform.vo.enums;


public enum DeviceTypeEnum {
	DEVICE_PC("PC", 0), //
	DEVICE_PHONE("手机", 1), //
	DEVICE_PANEL("平板", 2); //
	
	private String typeName;
	private Integer typeValue;

	private DeviceTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (DeviceTypeEnum osTypeEnum : DeviceTypeEnum.values()) {
			if (osTypeEnum.getTypeValue().equals(index)) {
				return osTypeEnum.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (DeviceTypeEnum osTypeEnum : DeviceTypeEnum.values()) {
			if (osTypeEnum.getTypeValue().equals(index)) {
				return osTypeEnum.getTypeValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getTypeName(2));
	}
}
