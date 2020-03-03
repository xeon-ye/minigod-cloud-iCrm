package com.minigod.api.user.vo.params;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;

public class AdLinkDetailVO extends SNUserBase {
	private static final long serialVersionUID = 1L;

	private List<Integer> posCodes;

	public List<Integer> getPosCodes() {
		return posCodes;
	}

	public void setPosCodes(List<Integer> posCodes) {
		this.posCodes = posCodes;
	}
}