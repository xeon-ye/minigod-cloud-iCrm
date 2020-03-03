/**
 * @Title: EOrderDirection.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 委托属性枚举类
 *
 * @author minigod
 * @date 2015-3-12 下午3:11:38
 * @version v1.0
 */

public enum EOrderProperty {
	L("限价委托"),
	M("市价委托");

	private String typeName;

	private EOrderProperty(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public static EOrderProperty findByValue(String orderBs) {
		for (EOrderProperty eOrderProperty : EOrderProperty.values()) {
			if (eOrderProperty.toString().equals(orderBs)) {
				return eOrderProperty;
			}
		}
		return null;
	}
	
}
