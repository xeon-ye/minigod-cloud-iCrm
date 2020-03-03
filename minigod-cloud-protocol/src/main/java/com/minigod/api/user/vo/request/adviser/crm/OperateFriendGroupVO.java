package com.minigod.api.user.vo.request.adviser.crm;

import java.io.Serializable;

public class OperateFriendGroupVO implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String type; //操作类型 :A新增、U修改、D删除
	private Integer groupId; //分组id
	private String groupName; //分组名
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
