package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.adviser.vo.params.CustomerQaHistory;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 回答者角色 查看提问者的历史提问
 */
@TransferBean
public class ReqCustomerQaHistoryVO extends SNVersion {

	private static final long serialVersionUID = 4926141855371145977L;
	
	@TransferID
	@Emoji
	private CustomerQaHistory params;

	public CustomerQaHistory getParams() {
		return params;
	}

	public void setParams(CustomerQaHistory params) {
		this.params = params;
	}
}
