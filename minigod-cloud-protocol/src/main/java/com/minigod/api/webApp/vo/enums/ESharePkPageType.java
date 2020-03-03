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

public enum ESharePkPageType {
	I("活动进行中页"),
	O("活动结束"), 
	N("无参与活动")	;
	
	private String typeName;
	
	private ESharePkPageType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
