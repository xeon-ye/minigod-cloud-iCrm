/**
 * @Title: EBrkClientType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 客户类型
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午3:44:49
 * @version v1.0
 */
public enum EBrkClientType {
	/**
	 * 个人客户
	 */
	SINGLE(0, "个人客户"),
	/**
	 * 机构客户
	 */
	ORGANISATION(1, "机构客户");

	private Integer typeValue;
	private String typeName;

	private EBrkClientType(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static EBrkClientType findByTypeValue(Integer val) {
		for (EBrkClientType eAccountType : EBrkClientType.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
