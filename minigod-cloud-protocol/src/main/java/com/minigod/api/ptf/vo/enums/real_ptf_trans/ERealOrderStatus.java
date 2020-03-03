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

public enum ERealOrderStatus {
	A("待成交"), //
	B("交易中"), //
	C("全部成交"),
	D("部分撤销"),
	E("全部撤销"),
	F("提交失败"), //
	G("未成交"), //
	H("撤单中"),
	I("部分成交");
	
	private String typeName;

	private ERealOrderStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
}
