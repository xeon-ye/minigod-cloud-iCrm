package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class FriendInvitation extends SNUserBase {
	private static final long serialVersionUID = 8413031489286268332L;

	private Integer invId;//邀请码ID
	private String beUserName;//被邀请人姓名
	private String bePhone;//被邀请人手机号

	public Integer getInvId() {
		return invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getBeUserName() {
		return beUserName;
	}

	public void setBeUserName(String beUserName) {
		this.beUserName = beUserName;
	}

	public String getBePhone() {
		return bePhone;
	}

	public void setBePhone(String bePhone) {
		this.bePhone = bePhone;
	}
}
