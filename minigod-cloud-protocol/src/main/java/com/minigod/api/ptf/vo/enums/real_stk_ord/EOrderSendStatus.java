/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_stk_ord;

/**
 * @description 个股委托发送状态
 *
 * @author minigod
 * @date 2015-3-17
 * @version v1.0
 */

public enum EOrderSendStatus {
	N("待发送"), //
	R("发送中"), // 
	S("发送成功"), //
	O("发送超时"), //
	F("发送失败");

	private String typeName;

	private EOrderSendStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
