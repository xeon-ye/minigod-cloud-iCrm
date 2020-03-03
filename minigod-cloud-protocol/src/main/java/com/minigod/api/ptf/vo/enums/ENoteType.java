/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-17 下午5:37:30
 * @version v1.0
 */

public enum ENoteType {
	C("创建组合"),
	D("创建组合(实盘新样式)"),
	B("买入"), 
	S("卖出"),
	U("转实盘"),
	R("调仓"),
	F("跟单"),
	M("非组合点评"),
	N("资讯分享"),
	V("观点分享"),
	G("群组分享"),
	A("H5非组合投资圈");
	
	private String typeName;
	
	private ENoteType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
