package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.SearchUser;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class ReqSearchUser extends SNVersion {

	private static final long serialVersionUID = 796010654583927455L;
	
	@TransferID
	private SearchUser params;

	public SearchUser getParams() {
		return params;
	}

	public void setParams(SearchUser params) {
		this.params = params;
	}
}
