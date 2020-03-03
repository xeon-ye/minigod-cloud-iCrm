package com.minigod.api.ptf.vo.enums.invest_msg;

/**
 * 关联数据类型
 * @author THINK
 *
 */
public enum ERelaType {
	/**
	 * 我的投顾直播群列表
	 */
	A(true),
	/**
	 *  组合
	 */
	P(true),
	/**
	 * 组合续费
	 */
	F(true),
	/**
	 *  主贴
	 */
	N(false),
	/**
	 * 跳到直播间续费
	 */
	G(false),
	/**
	 * 直播群
	 */
	H(false),// -
	/**
	 * 投顾观点
	 */
	V(false),// - 
	/**
	 * 收支列表
	 */
	C(false),
	/**
	 * 组合订单列表
	 */
	L(true),

	/**
	 * 个股详情
	 */
	S(true);

	private boolean mix;

	public boolean isMix() {
		return mix;
	}

	public void setMix(boolean mix) {
		this.mix = mix;
	}
	
	ERelaType(boolean mix){
		this.mix = mix;
	}
	
	
}
