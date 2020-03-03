/**
 * @Title: EAccountType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;


/**
 * @description 业务类型
 *
 * @author 余俊斌
 * @date 2015年3月31日 下午2:49:35
 * @version v1.0
 */
public enum EBrkBusinessType {
	/**
	 * 证券买入
	 */
	STK_BUY(1, "证券买入"),
	/**
	 * 红股入账
	 */
	BONUS_RECORD(2, "红股入账"), 
	/**
	 * 证券卖出
	 */
	STK_SELL(3, "证券卖出"),
	/**
	 * 新股申购
	 */
	STK_APPLY(4, "新股申购"),
	/**
	 * 申购还款
	 */
	APPLY_REPAY(5, "申购还款"),
	/**
	 * 申购中签
	 */
	APPLY_SUCCESS(6, "申购中签"),
	/**
	 * 红利入账
	 */
	DIVIDEND_RECORD(7, "红利入账");

	private Integer typeValue;
	private String typeName;

	private EBrkBusinessType(Integer typeValue, String typeName) {
		this.typeValue = typeValue;
		this.typeName = typeName;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public static EBrkBusinessType findByTypeValue(Integer val) {
		for (EBrkBusinessType eAccountType : EBrkBusinessType.values()) {
			if (eAccountType.typeValue.equals(val)) {
				return eAccountType;
			}
		}
		return null;
	}
	
}
