/**
 * @Title: EAdviserViewpointType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-30 下午4:56:47
 * @version v1.0
 */

public enum EAdviserViewpointType {
	P("投顾观点"); 

	private String typeName;
	
	private EAdviserViewpointType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
