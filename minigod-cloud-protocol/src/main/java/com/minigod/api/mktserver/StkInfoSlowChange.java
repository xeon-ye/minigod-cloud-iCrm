package com.minigod.api.mktserver;

import java.io.Serializable;

/**
 * 定义结构，存储缓慢变化的证券统计数据，如52周最高最低、历史最高最低等
 * 
 * @author gc
 *
 */
public abstract class StkInfoSlowChange implements Serializable {
	private static final long serialVersionUID = 3133652316599596241L;
	//
	private String assetId;
	private Double w52h; // 52周最高
	private Double w52l; // 52周最低
	private Double hh; // 历史最高
	private Double hl; // 历史最低
	private Double volPerMin5Days; // 过去5日平均每分钟成交量
	//
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Double getW52h() {
		return w52h;
	}
	public void setW52h(Double w52h) {
		this.w52h = w52h;
	}
	public Double getW52l() {
		return w52l;
	}
	public void setW52l(Double w52l) {
		this.w52l = w52l;
	}
	public Double getHh() {
		return hh;
	}
	public void setHh(Double hh) {
		this.hh = hh;
	}
	public Double getHl() {
		return hl;
	}
	public void setHl(Double hl) {
		this.hl = hl;
	}
	public Double getVolPerMin5Days() {
		return volPerMin5Days;
	}
	public void setVolPerMin5Days(Double volPerMin5Days) {
		this.volPerMin5Days = volPerMin5Days;
	}
}
