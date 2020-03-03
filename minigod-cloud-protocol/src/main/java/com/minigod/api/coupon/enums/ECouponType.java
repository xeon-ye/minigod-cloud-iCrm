/**
 * @Title: ECouponType.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.enums;

/**
 * @description 卡券的类型
 * 
 * @author Jimmy
 * @date 2016-1-12 下午3:24:22
 * @version v1.0
 */

public enum ECouponType {
	INTEREST_ADD_RATE(1, "加息券");

	private int code;
	private String desc;

	private ECouponType(int iCode, String sDesc) {
		this.code = iCode;
		this.desc = sDesc;
	}

	public static ECouponType valueOf(int code) {
		switch (code) {
		case 1:
			return INTEREST_ADD_RATE;
		default:
			throw new RuntimeException("没有此类型的卡券, code=" + code);
		}
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
