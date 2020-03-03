/**
 * @Title: StkBaseInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-15 下午6:18:55
 * @version v1.0
 */

public class WarrantVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String assetId;// 股票资产ID
	private String stkName;// 股票名称
	private Double price;// 现价
	private Double stkChgPct;// 涨跌幅
	private Double volume; // 成交量
	private int secType = -1;// 股票类别
	private int secSType = -1;// 股票细分类别

	public WarrantVO(){

	}

	public WarrantVO(String assetId, String stkName, Double price, Double stkChgPct, Double volume){
		this.assetId = assetId;
		this.stkName = stkName;
		this.price = price;
		this.stkChgPct = stkChgPct;
		this.volume = volume;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public Double getStkChgPct() {
		return stkChgPct;
	}

	public void setStkChgPct(Double stkChgPct) {
		this.stkChgPct = stkChgPct;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public int getSecType() {
		return secType;
	}

	public void setSecType(int secType) {
		this.secType = secType;
	}

	public int getSecSType() {
		return secSType;
	}

	public void setSecSType(int secSType) {
		this.secSType = secSType;
	}
}
