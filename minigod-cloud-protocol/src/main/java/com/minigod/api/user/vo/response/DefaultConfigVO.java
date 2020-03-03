package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class DefaultConfigVO implements Serializable {

	private static final long serialVersionUID = -8920962058291137976L;

	private Integer maxStks;

	public Integer getMaxStks() {
		return maxStks;
	}

	public void setMaxStks(Integer maxStks) {
		this.maxStks = maxStks;
	}
}
