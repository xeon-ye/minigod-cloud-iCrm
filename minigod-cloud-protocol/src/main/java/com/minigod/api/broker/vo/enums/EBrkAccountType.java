/**
 * @Title: EAccountType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 账号类型
 *
 * @author 余俊斌
 * @date 2015年3月18日 上午10:21:55
 * @version v1.0
 */
public enum EBrkAccountType {
	/**
	 * 客户号
	 */
	CUST_ID(1, "客户号"),
	/**
	 * 资金账号
	 */
	DEPOSIT_ACC(2, "资金账号"), 
	/**
	 * 股东账号(深A)
	 */
	STKACC_SA(3, "股东账号(深A)"),
	/**
	 * 股东账号(沪A)
	 */
	STKACC_HA(4, "股东账号(沪A)");

	private Integer typeValue;
	private String typeName;

	private EBrkAccountType(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public static EBrkAccountType findByTypeValue(Integer val) {
		for (EBrkAccountType eAccountType : EBrkAccountType.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
