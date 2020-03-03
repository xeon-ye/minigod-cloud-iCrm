package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class CloseAdDetailVO extends SNUserBase {
	private static final long serialVersionUID = 1L;

	private Integer adId;

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}
}