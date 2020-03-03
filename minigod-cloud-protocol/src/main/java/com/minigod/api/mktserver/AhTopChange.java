package com.minigod.api.mktserver;

import java.io.Serializable;


/**
 * 港股通(沪/深)排行榜bean
 * @author lenovo
 *
 */
public class AhTopChange extends TopChange{// add by jjchou
	private static final long serialVersionUID = 1405495973161448984L;

	
//	private String mktCode;//市场
	private String stkName;//股票名
	private int secType;//类型
	private int secSType;//类型
	
    private String aShareAssetId;//对应的A股代码
    private String aShareStkName;//对应的A股名称
    private Double aShareprice;//对应的A股价格
    private Double aSharechangePct;//对应的A股涨跌幅
    private int aShareSecType;//对应的A股类型
    private int aShareSecSType;//对应的A股子类型
    
    
    private Double premium;//对应的A股涨跌幅

	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
	}
	public String getaShareAssetId() {
		return aShareAssetId;
	}
	public void setaShareAssetId(String aShareAssetId) {
		this.aShareAssetId = aShareAssetId;
	}
	public Double getaShareprice() {
		return aShareprice;
	}
	public void setaShareprice(Double aShareprice) {
		this.aShareprice = aShareprice;
	}
	public Double getaSharechangePct() {
		return aSharechangePct;
	}
	public void setaSharechangePct(Double aSharechangePct) {
		this.aSharechangePct = aSharechangePct;
	}
	public Double getPremium() {
		return premium;
	}
	public void setPremium(Double premium) {
		this.premium = premium;
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
	public int getaShareSecType() {
		return aShareSecType;
	}
	public void setaShareSecType(int aShareSecType) {
		this.aShareSecType = aShareSecType;
	}
	public int getaShareSecSType() {
		return aShareSecSType;
	}
	public void setaShareSecSType(int aShareSecSType) {
		this.aShareSecSType = aShareSecSType;
	}
	public String getaShareStkName() {
		return aShareStkName;
	}
	public void setaShareStkName(String aShareStkName) {
		this.aShareStkName = aShareStkName;
	}

	
	
	
}
