/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 是否在服务器中发送委托
 * 
 * @author 许德佑
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum EOrderInServerFlag {
	Y("服务器中发送委托"), //
	N("客户端中发送委托");//
	

	private String typeName;

	private EOrderInServerFlag(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
