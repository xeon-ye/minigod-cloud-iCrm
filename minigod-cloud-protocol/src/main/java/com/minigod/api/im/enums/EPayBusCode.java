/**
 * @Title: EPayBusCode.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-30 下午2:55:53
 * @version v1.0
 */

public enum EPayBusCode {
	PAID001, // 直播群付费
	REWD001, // 直播群打赏
	REWD002; // 观点打赏
	
	public static EPayBusCode getEPayBusCode(String sCode) {
		if (PAID001.name().equals(sCode)) {
			return PAID001;
		} else if (REWD001.name().equals(sCode)) {
			return REWD001;
		} else if (REWD002.name().equals(sCode)) {
			return REWD002;
		} else {
			throw new RuntimeException("不支持的类型,sCode=" + sCode);
		}
	}
}
