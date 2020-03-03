package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class ReqCustomeOpenVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	@TransferID
	private CustomerOpen params;

	public CustomerOpen getParams() {
		return params;
	}

	public void setParams(CustomerOpen params) {
		this.params = params;
	}

	@TransferBean
	public static class CustomerOpen extends SNUserBase {

		private static final long serialVersionUID = -6148586421924205449L;

		private String openType; // 开户类型

		public String getOpenType() {
			return openType;
		}

		public void setOpenType(String openType) {
			this.openType = openType;
		}

	}
}
