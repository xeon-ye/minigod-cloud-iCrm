/**
 * @Title: EStkaccType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.broker_stkacc_info;

/**
 * @description 股东账号类型
 * 
 * @author minigod
 * @date 2015-4-21 下午2:09:45
 * @version v1.0
 */

public enum EStkaccType {
	
	ORDINARY_CCCOUNT("普通账号", "0"), //
	CREDIT_ACCOUNT("信用账号", "1"), //
	STOCK_OPTIONS_ACCOUNT("个股期权账号", "2"); //

	private String typeName;
	private String typeValue;

	private EStkaccType(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return this.typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}
	
}
