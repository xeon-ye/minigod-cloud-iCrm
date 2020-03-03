/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.enums.real_stk_ord;

/**
 * @description 组合委托状态枚举类
 *
 * @author minigod
 * @date 2015-3-17
 * @version v1.0
 */

public enum EOrderStatus {
	S("成功"), //
	F("失败"),
	T("超时"); //

	private String typeName;

	private EOrderStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
