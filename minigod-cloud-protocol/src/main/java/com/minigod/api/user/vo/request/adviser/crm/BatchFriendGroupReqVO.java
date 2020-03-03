package com.minigod.api.user.vo.request.adviser.crm;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class BatchFriendGroupReqVO  extends SNUserBase {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<Long> userIds;//需分组的用户id集
	private Integer groupId;//分组id
	
	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
