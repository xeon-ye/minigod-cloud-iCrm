package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class SysMsgDetailVO extends SNUserBase {
	private static final long serialVersionUID = 1L;

	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}