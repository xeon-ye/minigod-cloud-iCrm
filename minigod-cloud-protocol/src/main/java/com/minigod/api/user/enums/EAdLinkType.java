/**
 * @Title: EAdLinkGroupType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-15 下午12:19:15
 * @version v1.0
 */

public enum EAdLinkType {
	P("组合详情"),
	V("观点详情"),
	E("投顾详情"),
	A("广告详情");
	
	private String typeName;
	
	private EAdLinkType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
