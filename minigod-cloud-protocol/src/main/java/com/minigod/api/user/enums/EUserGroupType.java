package com.minigod.api.user.enums;

public enum EUserGroupType {
	I("im群聊组"),
	F("好友分组");
	
	private String typeName;
	
	private EUserGroupType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
