/**
 * @Title: EBrkIdType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;

/**
 * @description 证件类型
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午4:18:50
 * @version v1.0
 */
public enum EBrkIdType {

	/** 身份证 */
	IDENTITY("0", "身份证"),
	/** 护照 */
	PASSPORT("1", "护照"),
	/** 营业执照 */
	BUSINESS_LICENCE("2", "营业执照"),
	/** 军官证 */
	OFFICER_CERTIFICATE("3", "军官证"),
	/** 其他 */
	OTHER("4", "其他"),
	/** 组织机构代码 */
	ORG_CODE("A", "组织机构代码"),
	/** 社会团体 */
	SOCIAL_GROUP("B", "社会团体");

	private String typeName;
	private String typeValue;

	private EBrkIdType(String typeValue, String typeName) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}
	
	public String getTypeValue() {
		return typeValue;
	}

	public static EBrkIdType findByTypeName(String name) {
		for (EBrkIdType eCurrencyType : EBrkIdType.values()) {
			if (eCurrencyType.typeName.equals(name)) {
				return eCurrencyType;
			}
		}
		return null;
	}

}
