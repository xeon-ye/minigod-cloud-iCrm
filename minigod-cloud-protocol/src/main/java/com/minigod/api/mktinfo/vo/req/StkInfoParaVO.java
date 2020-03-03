package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

public class StkInfoParaVO extends BaseVO {

	private static final long serialVersionUID = -2793781419861695764L;
	private String assetId;//资产ID

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

}
