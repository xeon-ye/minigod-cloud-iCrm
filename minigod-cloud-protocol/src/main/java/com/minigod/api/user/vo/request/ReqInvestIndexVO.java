package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class ReqInvestIndexVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;

	@TransferID
	private InvestIndex params;

	public InvestIndex getParams() {
		return params;
	}

	public void setParams(InvestIndex params) {
		this.params = params;
	}

	@TransferBean
	public static class InvestIndex extends SNUserBase {

		private static final long serialVersionUID = -6148586421924205449L;

		private Type type; // 请求类型

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

	}

	public static enum Type {

		M// 最近一个月
		, Y// 今年以来;

	}
}
