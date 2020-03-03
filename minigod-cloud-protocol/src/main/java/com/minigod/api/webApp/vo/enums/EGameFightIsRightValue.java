/**
 * @Title: EGameFightIsRightValue.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.enums;

/**
 * @description 一战到底 竞猜值是否正确
 *
 * @author panlz
 * @date 2015-12-7 下午5:37:30
 * @version v1.0
 */

public enum EGameFightIsRightValue {
	error("错误", 0), 
	correct("正确", 1);
	
	private String typeName;
	private Integer typeValue;

	private EGameFightIsRightValue(String typeName, Integer typeValue) {
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
