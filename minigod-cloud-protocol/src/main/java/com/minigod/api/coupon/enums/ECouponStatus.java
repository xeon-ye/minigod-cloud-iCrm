/**
 * @Title: ECouponStatus.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.enums;

/**
 * @description 卡券的状态
 * 
 * @author Jimmy
 * @date 2016-1-12 下午8:29:18
 * @version v1.0
 */

public enum ECouponStatus {
	N, // 未使用（正常）
	U, // 已使用
	E, // 已过期
	D, // 已经回收
	A // 所有的
	;
}
