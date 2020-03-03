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

public enum EPkStatus {
	W("胜利"),
	F("失败"), 
	D("平局"),
	N("未开始"),
	O("进行时"),
	E("结束");
	
	private String typeName;
	
	private EPkStatus(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
