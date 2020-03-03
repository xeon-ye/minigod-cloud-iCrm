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

public enum ESimuFollowBusType{
	B("买入"), //
	S("卖出"),
	A("新增"),
	C("清仓"); //

	private String typeName;

	private ESimuFollowBusType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
}
