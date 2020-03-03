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

public enum EOrderDisplayStatus {
	/**
	 * 待成交
	 */
	A("待成交"), //
	
	/**
	 * 交易中
	 */
	B("交易中"), //
	
	/**
	 * 全部成交
	 */
	C("全部成交"), //
	
	/**
	 * 部分撤销
	 */
	D("部分撤销"), //
	
	/**
	 * 全部撤销
	 */
	E("全部撤销"), //
	
	/**
	 * 委托失败
	 */
	F("委托失败"), //
	
	/**
	 * 发送异常
	 */
	G("发送异常"), //
	
	/**
	 * 未成交
	 */
	H("未成交"),
	
	/**
	 * 撤单中
	 */
	I("撤单中"),
	
	/**
	 * 部分成交（已经结束）
	 */
	J("部分成交");

	private String typeName;

	private EOrderDisplayStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
