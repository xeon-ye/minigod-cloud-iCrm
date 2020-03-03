/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.broker_deposit_info;


/**
 * @description 
 *
 * @author 许德佑
 * 
 */

public enum EDepositAccType{
	_0("普通资金账号","0"), //
	_1("融资融券资金账号","1"),
	_2("个股期权资金账号","2"); //

	private String typeName;
	private String typeValue;

	private EDepositAccType(String typeName,String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getTypeValue(){
		return this.typeValue;
	}

}
