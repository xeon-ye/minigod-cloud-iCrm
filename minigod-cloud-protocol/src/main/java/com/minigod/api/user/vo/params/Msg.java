package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class Msg extends SNUserBase {

	private static final long serialVersionUID = 3526219548505952520L;
	private Integer noticeId;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
}