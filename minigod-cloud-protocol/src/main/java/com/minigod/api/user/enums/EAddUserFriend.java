/**
 * @Title: EAddUserFriend.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-16 下午7:04:36
 * @version v1.0
 */

public enum EAddUserFriend {
	SUCCESS("发送好友申请成功", 0),
	ALREADY_FRIEND("已是好友关系",1),
	LIMIT_NUM_OVER("抢购数量已完",2),
	EXCEED_YOUR_LIMIT("超过自己的好友上限",3),
	NOT_NEED_ADD_OWN("不需添加自己为好友",4);

	private String typeName;
	private Integer typeValue;

	private EAddUserFriend(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (EAddUserFriend eAddUserFriend : EAddUserFriend.values()) {
			if (eAddUserFriend.getTypeValue().equals(index)) {
				return eAddUserFriend.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (EAddUserFriend eAddUserFriend : EAddUserFriend.values()) {
			if (eAddUserFriend.getTypeValue().equals(index)) {
				return eAddUserFriend.getTypeValue();
			}
		}
		return null;
	}
}
