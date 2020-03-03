/**
 * @Title: EGameFightGuessValue.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 一战到底 猜涨跌值
 *
 * @author panlz
 * @date 2015-12-7 下午5:37:30
 * @version v1.0
 */

public enum EGameFightGuessValue {
	down("跌", 0), 
	up("涨", 1);
	
	private String typeName;
	private Integer typeValue;

	private EGameFightGuessValue(String typeName, Integer typeValue) {
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
