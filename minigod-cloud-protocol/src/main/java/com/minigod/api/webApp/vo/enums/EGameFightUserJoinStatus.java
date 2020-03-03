/**
 * @Title: EGameFightUserJoinStatus.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 一战到底 用户的赛事状态  
 *
 * @author panlz
 * @date 2015-12-7 下午5:37:30
 * @version v1.0
 */

public enum EGameFightUserJoinStatus {
	StartOn("进行中", 1),
	End("比赛结束", 9);
	
	
	private String typeName;
	private Integer typeValue;

	private EGameFightUserJoinStatus(String typeName, Integer typeValue) {
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
