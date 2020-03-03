/**
 * @Title: EBrkGender.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 性别
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午2:46:41
 * @version v1.0
 */
public enum EBrkGender {
	/**
	 * 女
	 */
	FEMALE(0, "女"),
	/**
	 * 男
	 */
	MALE(1, "男");

	private Integer typeValue;
	private String typeName;

	
	private EBrkGender(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
	
	public Integer getTypeValue() {
		return typeValue;
	}

	public static EBrkGender findByTypeValue(Integer val) {
		for (EBrkGender eAccountType : EBrkGender.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
