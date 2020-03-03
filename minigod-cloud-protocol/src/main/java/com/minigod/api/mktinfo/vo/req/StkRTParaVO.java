package com.minigod.api.mktinfo.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * <code>StkSumVO<code>[个股概要信息查询类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */
public class StkRTParaVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;

	private String ptfId;
	private List<String> assetIds; // 资产ID集合

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public String getPtfId() {
		return ptfId;
	}

	public void setPtfId(String ptfId) {
		this.ptfId = ptfId;
	}

}
