package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

public class StkInfoRequestVO extends SNVersion {

	private static final long serialVersionUID = -833770843357266413L;

	private StkInfoParaVO params;

	public StkInfoParaVO getParams() {
		return params;
	}

	public void setParams(StkInfoParaVO params) {
		this.params = params;
	}
}
