/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_ptf_trans;

/**
 * @description 
 *
 * @author 许德佑
 * @date 2015-3-17
 * @version v1.0
 */

public enum ERealPtfTransType {
	B("买入"), 
	S("卖出"),
	R("调仓"),
	D("分红"),
	W("撤单"),
	F("跟单"); 

	private String typeName;

	private ERealPtfTransType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
