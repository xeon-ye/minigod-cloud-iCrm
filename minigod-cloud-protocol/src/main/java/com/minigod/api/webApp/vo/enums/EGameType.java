/**
 * @Title: EGameType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-10 下午1:29:36
 * @version v1.0
 */

public enum EGameType {
	GU_SHENG("股神来了", 0),
	GAME_ADVISER("投顾大赛", 1);

	private String typeName;
	private Integer typeValue;

	private EGameType(String typeName, Integer typeValue) {
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
