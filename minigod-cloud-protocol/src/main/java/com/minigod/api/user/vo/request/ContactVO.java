package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.Contact;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class ContactVO extends SNVersion {

	private static final long serialVersionUID = 4324808165255689269L;

	@Emoji
	public Contact params;

	public Contact getParams() {
		return params;
	}

	public void setParams(Contact params) {
		this.params = params;
	}
}
