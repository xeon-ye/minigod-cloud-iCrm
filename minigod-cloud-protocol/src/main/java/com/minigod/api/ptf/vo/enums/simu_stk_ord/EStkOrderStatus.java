/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_stk_ord;

/**
 * @description 模拟委托状态枚举类
 * 
 * @author minigod
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum EStkOrderStatus {
	UNSEND("未报", "0"), //
	TO_BE_SENT("待报", "1"), //
	SENT("已报", "2"), //
	SENT_AND_CANCELING("已报待撤", "3"), //
	PART_SUCESS_OTHER_CANCELING("部成待撤", "4"), //
	PART_CANCELED("部撤", "5"), //
	ALL_CANCELED("已撤", "6"), //
	PART_SUCCESS("部成", "7"), //
	SUCCESS("已成", "8"), //
	INVALID_ORDER("废单", "9"), //
	FAILED_TO_CANCEL("撤单未成", "10"); //
	
	

	private String typeName;
	private String typeValue;

	private EStkOrderStatus(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return this.typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
