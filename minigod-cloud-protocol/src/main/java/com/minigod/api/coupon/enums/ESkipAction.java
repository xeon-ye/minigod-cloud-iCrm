/**
 * @Title: ESkipAction.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.enums;

/**
 * @description 跳转的Action值
 * 
 * @author Jimmy
 * @date 2016-1-14 下午9:14:12
 * @version v1.0
 */

public enum ESkipAction {
	NO_ACTION(0), // 没有跳转动作
	IMMEDIATELY_BUY(1), // 立即购买（活期）
	MORE_RATE_COUPONS(2), // 更多加息券
	CONFIRM_USE(3), // 确定使用
	ADD_TO(4), // 追加购买
	CONTACT_SERVICE(5), // 联系客服
	;

	private int code;

	private ESkipAction(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
