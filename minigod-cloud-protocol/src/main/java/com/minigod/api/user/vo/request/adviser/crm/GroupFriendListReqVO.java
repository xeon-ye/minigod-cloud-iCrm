package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.vo.BaseVO;

public class GroupFriendListReqVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private Integer groupId;
	private String groupType;
	private String imGroupId;
	private Integer readVersion;
	private Integer limitNum;
	public Integer getReadVersion() {
		return readVersion;
	}
	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}
	public Integer getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
	public String getImGroupId() {
		return imGroupId;
	}
	public void setImGroupId(String imGroupId) {
		this.imGroupId = imGroupId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
}
