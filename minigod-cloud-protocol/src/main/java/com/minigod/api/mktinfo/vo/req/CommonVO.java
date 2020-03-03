package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;

/**
 * 
 * <code>StkSumVO<code>[个股概要信息查询类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */
public class CommonVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;

	private String assetId;
	private List<String> assetIds; // 资产ID集合
	private String date;

	private String market;
	private String dstDir;

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getDstDir() {
		return dstDir;
	}

	public void setDstDir(String dstDir) {
		this.dstDir = dstDir;
	}
}
