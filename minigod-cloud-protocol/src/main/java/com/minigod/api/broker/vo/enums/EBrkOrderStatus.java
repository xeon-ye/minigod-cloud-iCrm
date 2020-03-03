/**
 * @Title: EBrkOrderStatus.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;

/**
 * @description 委托状态
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午2:02:26
 * @version v1.0
 */
public enum EBrkOrderStatus {
	UNSEND("未报", "0"), //
	SENTING("正报", "1"), //
	SENT("已报", "2"), //
	SENT_AND_CANCELING("已报待撤", "3"), //
	PART_SUCESS_OTHER_CANCELING("部成待撤", "4"), //
	PART_CANCELED("部撤", "5"), //
	ALL_CANCELED("已撤", "6"), //
	PART_SUCCESS("部成", "7"), //
	SUCCESS("已成", "8"), //
	INVALID_ORDER("废单", "9");//

	
	

	private String typeName;
	private String typeValue;

	private EBrkOrderStatus(String typeName, String typeValue) {
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
