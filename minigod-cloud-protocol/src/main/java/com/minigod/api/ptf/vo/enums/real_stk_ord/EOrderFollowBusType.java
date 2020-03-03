/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_stk_ord;

/**
 * @description 个股委托跟单业务类别
 *
 * @author minigod
 * @date 2015-3-17
 * @version v1.0
 */

public enum EOrderFollowBusType {
	BUY("加仓", "B"), //
	SALE("减仓", "S"),
	ADD("新增", "A"),
	CLEAR("清仓", "C"); //

	private String typeName;
	private String typeValue;

	private EOrderFollowBusType(String typeName, String typeValue) {
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
