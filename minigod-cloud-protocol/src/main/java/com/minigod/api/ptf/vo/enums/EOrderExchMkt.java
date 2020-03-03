/**
 * @Title: EOrderDirection.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 交易市场类型
 *
 * @author minigod
 * @date 2015-3-12 下午3:11:38
 * @version v1.0
 */

public enum EOrderExchMkt {
	HA("沪A"),
	HB("沪B"),
	SA("深A"),
	SB("深B"),
	HK("香港"),
	STA("特别转让A"),
	STB("特别转让B"),
	NEB("非交易所债券"),
	OF("开放式基金"),
	UNKNOWN("未知");
	
	private String typeName;

	private EOrderExchMkt(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * 判断当前的交易市场是否在交易市场枚举类中
	 * 
	 * @param strExchMtkType
	 * @return
	 */
	public static boolean contains(String strExchMtkType) {
		for (EOrderExchMkt eOrderDirection : EOrderExchMkt.values()) {
			if (eOrderDirection.toString().equals(strExchMtkType)) {
				return true;
			}
		}
		return false;
	}
	
	public static EOrderExchMkt findByValue(String orderBs) {
		for (EOrderExchMkt eOrderExchMkt : EOrderExchMkt.values()) {
			if (eOrderExchMkt.toString().equals(orderBs)) {
				return eOrderExchMkt;
			}
		}
		return null;
	}
	
}
