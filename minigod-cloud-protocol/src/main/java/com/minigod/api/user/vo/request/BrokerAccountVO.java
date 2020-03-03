package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.BrokerAccount;

/**
 * 添加券商账户
 */

public class BrokerAccountVO extends SNVersion {

	private static final long serialVersionUID = -8592184863127323105L;

	public BrokerAccount params;

	public BrokerAccount getParams() {
		return params;
	}

	public void setParams(BrokerAccount params) {
		this.params = params;
	}
}
