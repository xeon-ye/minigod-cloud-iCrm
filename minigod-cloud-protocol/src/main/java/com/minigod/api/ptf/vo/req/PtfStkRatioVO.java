/*
 * FileName: PtfStkRatioVO.java
 * Copyright: Copyright 2014-12-2 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

/**
 * <code>PtfStkRatioVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-2)
 *
 */
public class PtfStkRatioVO {
	private String assetId;
	
	private Double src;
	
	private Double tar;
	
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Double getSrc() {
		return src;
	}
	public void setSrc(Double src) {
		this.src = src;
	}
	public Double getTar() {
		return tar;
	}
	public void setTar(Double tar) {
		this.tar = tar;
	}
}
