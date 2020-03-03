package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.vo.BaseVO;

public class SearchUserReqVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String keyWords;

	private String groupId; // 群ID , 在PC端用到

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
