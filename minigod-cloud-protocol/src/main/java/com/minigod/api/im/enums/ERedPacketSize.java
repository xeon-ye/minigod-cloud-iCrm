/**
 * @Title: ERedPacketSize.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

import java.math.BigDecimal;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-12-1 下午3:10:41
 * @version v1.0
 */
public enum ERedPacketSize {
	S(0, "红包"), M(1, "大红包"), L(2, "大大的红包"), ;

	private int size;

	private String value;

	private ERedPacketSize(int size, String value) {
		this.size = size;
		this.value = value;
	}

	public static ERedPacketSize matchSize(BigDecimal amount) {
		if (amount == null) {
			throw new RuntimeException("#matchSize 输入的参数为空");
		}
		if (amount.compareTo(new BigDecimal(0)) > 0 && amount.compareTo(new BigDecimal(18)) < 0) {
			return ERedPacketSize.S;
		} else if (amount.compareTo(new BigDecimal(18)) >= 0
				&& amount.compareTo(new BigDecimal(58)) < 0) {
			return ERedPacketSize.M;
		} else if (amount.compareTo(new BigDecimal(58)) >= 0
				&& amount.compareTo(new BigDecimal(200)) <= 0) {
			return ERedPacketSize.L;
		} else {
			throw new RuntimeException("#matchSize 不支持的数值, amount=" + amount);
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
