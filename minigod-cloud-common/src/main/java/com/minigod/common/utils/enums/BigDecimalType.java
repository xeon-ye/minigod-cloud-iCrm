package com.minigod.common.utils.enums;

/**
 * @Title: BigDecimalType.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-4-8 下午2:21:17
 * @version v1.0
 */

public enum BigDecimalType {
	ROUND_HALF_UP(4), ROUND_HALF_DOWN(5);

	private final int value;

	BigDecimalType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
