/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_stk_ord;

/**
 * @description 委托发送状态枚举类
 * 
 * @author minigod
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum EStkSendStatus {
	TO_BE_SENT("待发送", "N"), //
	SENDING("发送中", "R"), // 
	SUCCESS("发送成功", "S"), //
	TIME_OUT("发送超时", "O"); //


	private String typeName;
	private String typeValue;

	private EStkSendStatus(String typeName, String typeValue) {
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
