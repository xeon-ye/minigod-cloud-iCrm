/**
 * @Title: ECurrencyType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 币种
 *
 * @author 余俊斌
 * @date 2015年3月18日 上午10:21:55
 * @version v1.0
 */
public enum EBrkCurrencyType {
	/**
	 * 人民币
	 */
	RMB("人民币"),
	/**
	 * 港币
	 */
	HKD("港币"), 
	/**
	 * 美元
	 */
	USD("美元"); 

	private String typeName;

	private EBrkCurrencyType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public static EBrkCurrencyType findByTypeName(String name) {
		for (EBrkCurrencyType eCurrencyType : EBrkCurrencyType.values()) {
			if (eCurrencyType.typeName.equals(name)) {
				return eCurrencyType;
			}
		}
		return null;
	}
	
}
