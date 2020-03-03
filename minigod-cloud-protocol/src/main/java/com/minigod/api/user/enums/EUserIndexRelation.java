/**
 * @Title: EUserRelation.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description 个人主页时使用
 * 
 * @author 谢尚河
 * @date 2015-11-4 上午10:48:10
 * @version v1.0
 */

public enum EUserIndexRelation {

	ADVISER_SELF(0), // 0：投顾本人
	CUSTOMER_ADVISER(1), // 1：客户-投顾关系(客户为普通客户)
	NOTCUSTOMER_ADVISER_FRIEND(2), // 2：非客户-投顾好友关系
	NOTCUSTOMER_ADVISER_STRANGER(3), // 3：非客户-投顾陌生人关系
	ADVISER_ADVISER_FRIEND(4), // 4：投顾-投顾好友关系
	ADVISER_ADVISER_STRANGER(5), // 5：投顾-投顾陌生人关系
	CUSTOMER_SELF(6), // 6：用户本人关系
	ADVISER_CUSTOMER(7), // 7：投顾-客户关系
	CUSTOMER_CUSTOMER_FRIEND(8), // 8：客户间普通好友
	STRANGER(9), // 9：陌生人
	ADVISER_CUSTOMER_FRIEND(10),// 10：投顾-客户普通好友
	ADVISER_ADVISER_CUSTOMER(11);// 11：客户-投顾(客户为投顾)关系
	
	private Integer typeValue;

	private EUserIndexRelation(Integer typeValue) {
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}
}
