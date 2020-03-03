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

public enum EGSgameStatus {
	Wait("等待开赛", 0), 
	StartOn("开赛进行中", 1), 
	End("比赛结束", 2),
	Cancel("比赛作废", 3);
	
	private String typeName;
	private Integer typeValue;

	private EGSgameStatus(String typeName, Integer typeValue) {
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
