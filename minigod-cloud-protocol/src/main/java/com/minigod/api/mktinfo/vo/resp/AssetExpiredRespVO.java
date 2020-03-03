package com.minigod.api.mktinfo.vo.resp;
/**
 * <code>AssetExpiredHolder<code> 过期的资产 
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-27)
 *
 */
public class AssetExpiredRespVO {
	private String assetId;
	private Integer delLocal;
	public AssetExpiredRespVO(String assetId, Integer delLocal) {
		super();
		this.assetId = assetId;
		this.delLocal = delLocal;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Integer getDelLocal() {
		return delLocal;
	}
	public void setDelLocal(Integer delLocal) {
		this.delLocal = delLocal;
	}
}
