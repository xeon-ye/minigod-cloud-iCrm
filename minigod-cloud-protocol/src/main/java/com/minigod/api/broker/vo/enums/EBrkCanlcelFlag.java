/**
 * @Title: EWithdrawFlag.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 撤单标识
 *
 * @author 余俊斌
 * @date 2015年4月3日 下午7:53:00
 * @version v1.0
 */
public enum EBrkCanlcelFlag {
	/**
	 * 正常委托
	 */
	N("T", "正常委托"),
	/**
	 * 撤单
	 */
	W("F", "撤单");

	private String typeValue;
	private String typeName;

	private EBrkCanlcelFlag(String typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}

	public String getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static EBrkCanlcelFlag findByTypeValue(String val) {
		for (EBrkCanlcelFlag ecancelFlag : EBrkCanlcelFlag.values()) {
			if (ecancelFlag.typeValue.equals(val)) {
				return ecancelFlag;
			}
		}
		return null;
	}
	
}
