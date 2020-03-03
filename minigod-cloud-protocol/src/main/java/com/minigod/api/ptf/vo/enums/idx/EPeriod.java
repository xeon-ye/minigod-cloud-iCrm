/**
 * @Title: EPeriod.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.idx;

/**
 * @description 周期
 *
 * @author Jimmy
 * @date 2015-3-28 下午12:09:54
 * @version v1.0
 */

public enum EPeriod {
	YEAR("年", 1),
	MONTH("月", 2),
	WEEK("周", 3);
	private String name;
	private int value;

	private EPeriod(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
