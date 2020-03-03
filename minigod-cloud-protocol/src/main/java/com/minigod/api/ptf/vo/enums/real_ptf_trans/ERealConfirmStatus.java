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

public enum ERealConfirmStatus {
	N("未成交"), //
	S("全部成交"),
	P("部分成交"); //

	private String typeName;

	private ERealConfirmStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
}
