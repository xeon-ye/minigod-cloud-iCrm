/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_stk_ord;

/**
 * @description 委托结束状态枚举类
 * 
 * @author minigod
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum EStkFinishStatus {
	N("未结束", "N"), //（包括全部成交、部分撤销、全部撤销、废单）
	Y("已结束", "Y"); //


	private String typeName;
	private String typeValue;

	private EStkFinishStatus(String typeName, String typeValue) {
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
