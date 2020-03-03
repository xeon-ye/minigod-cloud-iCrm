/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-17 下午5:37:30
 * @version v1.0
 */

public enum EPkContentPageType {
	N("无组合列表页"),
	P("有组合列表页"), 
	H("已提交组合页"),
	O("有参与活动且活动结束"),
	W("无参与活动且活动结束");
	
	private String typeName;
	
	private EPkContentPageType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
