/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_ptf_trans;

/**
 * @description 
 *
 * @author minigod
 * @date 2015-3-13 下午2:59:02
 * @version v1.0
 */

public enum ERealPtfSendStatus {
	TO_BE_SEND("待发送", "N"), //
	ALL_SENT_FAILED("全部发送失败", "F"), //
	ALL_SUCCESS("全部下单成功", "S"),
	PART_SUCCESS("部分下单成功", "P"); //

	private String typeName;
	private String typeValue;

	private ERealPtfSendStatus(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getTypeValue() {
		return this.typeValue;
	}
	
}
