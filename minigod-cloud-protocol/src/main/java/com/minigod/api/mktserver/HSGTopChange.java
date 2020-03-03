package com.minigod.api.mktserver;

import java.io.Serializable;


/**
 * @author jjchou
 * @version v1.0
 * @project: minigod
 * @description:
 * @copyright:2017
 * @company: 
 * 2017年6月19日
 */
public class HSGTopChange extends TopChange{// add by jjchou
	private static final long serialVersionUID = 1405495973161448984L;
	private Double amplitude;//振幅
	private Double turnrate;//换手率
	private String mktCode;//市场
	private String stkName;//股票名
	private int secType;//类型
	private int secSType;//子类型
	

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
	public String getMktCode() {
		return mktCode;
	}
	public void setMktCode(String mktCode) {
		this.mktCode = mktCode;
	}
	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
	}
	public Double getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(Double amplitude) {
		this.amplitude = amplitude;
	}
	public Double getTurnrate() {
		return turnrate;
	}
	public void setTurnrate(Double turnrate) {
		this.turnrate = turnrate;
	}
}
