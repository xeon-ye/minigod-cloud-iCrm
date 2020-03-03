package com.minigod.api.mktmgr.vo.req;

import com.minigod.api.user.vo.SNVersion;


public class StockLogReqVO extends  SNVersion {

	private static final long serialVersionUID = -4795436481254306490L;

	private LogMktReqVO params;

	public LogMktReqVO getParams() {
		return params;
	}

	public void setParams(LogMktReqVO params) {
		this.params = params;
	}
	
}
