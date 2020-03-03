package com.minigod.api.user.enums;

public enum GroupOperateType {
	A("新增"),
	U("修改"),
	D("删除");
	
	private String typeName;
	
	private GroupOperateType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
