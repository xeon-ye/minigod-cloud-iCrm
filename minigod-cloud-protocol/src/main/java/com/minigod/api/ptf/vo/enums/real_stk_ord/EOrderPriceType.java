/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_stk_ord;

/**
 * @description 个股委托报价方式
 *
 * @author minigod
 * @date 2015-3-17
 * @version v1.0
 */

public enum EOrderPriceType {
	L("限价委托"), //
	M("市价委托"); //

	private String typeName;

	private EOrderPriceType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
