/**
 * @Title: EBrkEducationDegree.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;



/**
 * @description 学历
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午2:49:57
 * @version v1.0
 */
public enum EBrkEducationDegree {
	/**
	 * 其他
	 */
	OTHER(0,"其他"),
	/**
	 * 博士
	 */
	DOCTOR(1, "博士"),
	/**
	 * 硕士
	 */
	MASTER(2, "硕士"),
	/**
	 * 学士
	 */
	BACHELOR(3, "学士"),
	/**
	 * 大专
	 */
	JUNIOR_COLLEGE(4, "大专"),
	/**
	 * 中专
	 */
	TECHNICAL_SECONDARY(5, "中专"),
	/**
	 * 高中
	 */
	SENIOR_HIGH(6, "高中"),
	/**
	 * 初中及其以下
	 */
	BELOW_JUNIOR_HIGH(7, "初中及其以下");

	private Integer typeValue;
	private String typeName;

	private EBrkEducationDegree(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static EBrkEducationDegree findByTypeValue(Integer val) {
		for (EBrkEducationDegree eAccountType : EBrkEducationDegree.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
