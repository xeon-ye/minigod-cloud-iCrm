/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_stk_ord;


/**
 * @description 
 *
 * @author minigod
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum ESimuBusType{
	B("买入", "B"), //
	S("卖出", "S"),
	W("撤单", "W"); //

	private String typeName;
	private String typeValue;

	private ESimuBusType(String typeName, String typeValue) {
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
