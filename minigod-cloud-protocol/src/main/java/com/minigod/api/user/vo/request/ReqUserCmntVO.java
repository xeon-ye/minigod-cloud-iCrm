package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UserCmnt;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class ReqUserCmntVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;
	
	@TransferID
	private UserCmnt params;

	public UserCmnt getParams() {
		return params;
	}

	public void setParams(UserCmnt params) {
		this.params = params;
	}
}
