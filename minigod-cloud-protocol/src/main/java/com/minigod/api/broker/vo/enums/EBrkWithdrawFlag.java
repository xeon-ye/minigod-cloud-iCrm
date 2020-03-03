/**
 * @Title: EWithdrawFlag.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 可撤单标识
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午1:45:28
 * @version v1.0
 */
public enum EBrkWithdrawFlag {
	/**
	 * 查询全部
	 */
	ALL(0, "查询全部"),
	/**
	 * 只查可撤
	 */
	WITHDRAW_ONLY(1, "只查可撤");

	private Integer typeValue;
	private String typeName;

	private EBrkWithdrawFlag(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static EBrkWithdrawFlag findByTypeValue(Integer val) {
		for (EBrkWithdrawFlag eAccountType : EBrkWithdrawFlag.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
