package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserGender extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;

	private Integer newGender;//0女1男

	public Integer getNewGender() {
		return newGender;
	}

	public void setNewGender(Integer newGender) {
		this.newGender = newGender;
	}
}
