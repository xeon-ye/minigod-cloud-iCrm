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

public enum ERedEnvelopeNum {
	UN_JOIN("未参与活动", 0),
	HAS_JOIN("已参与活动",1),
	END_JOIN("活动已截止",2),
	ZERO_JOIN("红包抢完",3);

	private String typeName;
	private Integer typeValue;

	private ERedEnvelopeNum(String typeName, Integer typeValue) {
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
