package com.minigod.api.platform.vo.enums;

/**
 * @Title: MsgStatusTypeEnum.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-12-29 下午9:10:52
 * @version v1.0
 */

public enum MsgStatusTypeEnum {
	SENDING("发送中", 0), //
	SUCESS("发送成功", 1), //
	FAILURE("发送失败", 2); //

	private String typeName;
	private Integer typeValue;

	private MsgStatusTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (MsgStatusTypeEnum msgStatusTypeEnum : MsgStatusTypeEnum.values()) {
			if (msgStatusTypeEnum.getTypeValue().equals(index)) {
				return msgStatusTypeEnum.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (MsgStatusTypeEnum msgStatusTypeEnum : MsgStatusTypeEnum.values()) {
			if (msgStatusTypeEnum.getTypeValue().equals(index)) {
				return msgStatusTypeEnum.getTypeValue();
			}
		}
		return null;
	}
}
