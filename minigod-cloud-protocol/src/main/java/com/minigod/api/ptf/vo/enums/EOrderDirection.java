/**
 * @Title: EOrderDirection.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 买卖方向枚举类
 *
 * @author minigod
 * @date 2015-3-12 下午3:11:38
 * @version v1.0
 */

public enum EOrderDirection {
	B("买"), // 买
	S("卖"); // 卖

	private String typeName;

	private EOrderDirection(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	
	public static EOrderDirection findByValue(String orderBs) {
		for (EOrderDirection eOrderDirection : EOrderDirection.values()) {
			if (eOrderDirection.toString().equals(orderBs)) {
				return eOrderDirection;
			}
		}
		return null;
	}
	
}
