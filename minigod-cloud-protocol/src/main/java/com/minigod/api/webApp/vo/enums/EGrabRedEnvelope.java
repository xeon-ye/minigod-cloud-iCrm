/**
 * @Title: EAddUserFriend.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-16 下午7:04:36
 * @version v1.0
 */

public enum EGrabRedEnvelope {
	UN_WEIXIN("未绑定微信", 0),
	RED_ZERO("红包抢完",1),
	SUCCESS("成功参与",2);

	private String typeName;
	private Integer typeValue;

	private EGrabRedEnvelope(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName(){
		return this.typeName;
	}
}
