package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class NewFriends extends SNUserBase {

	private static final long serialVersionUID = 1728840520889915284L;
	private Long contactVersion;//通过联系人获取的推荐好友信息
	private Long invVersion;//通过申请获取的推荐好友信息

	public Long getContactVersion() {
		return contactVersion;
	}

	public void setContactVersion(Long contactVersion) {
		this.contactVersion = contactVersion;
	}

	public Long getInvVersion() {
		return invVersion;
	}

	public void setInvVersion(Long invVersion) {
		this.invVersion = invVersion;
	}
}
