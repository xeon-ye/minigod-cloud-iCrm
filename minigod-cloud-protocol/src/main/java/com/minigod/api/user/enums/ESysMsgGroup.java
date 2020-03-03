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

public enum ESysMsgGroup {
	P("个人"),
	A("全站");
	
	private String typeName;
	
	private ESysMsgGroup(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
