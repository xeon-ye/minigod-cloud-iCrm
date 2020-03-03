/**
 * @Title: SysMsgGroupEnum.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-5-29 下午3:49:10
 * @version v1.0
 */

public enum ESysMsgType {
	A("活动"),
	R("提醒"),
	N("公告"),
	X("要闻"),
	B("播报");
	
	private String typeName;
	
	private ESysMsgType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
