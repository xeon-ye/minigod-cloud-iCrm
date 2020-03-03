/**
 * @Title: MktinfoInnerStockVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 个股对象
 * @author 余俊斌
 * @date 2015年8月19日 下午9:43:15
 * @version v1.0
 */
public class MktinfoJfStockVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5723748465093822077L;
	private String stkName;
	private String assetId;
	private Double stkChgPct;//涨跌幅度
	private Double stkChg;//涨跌额度
	private Object stype;//证券子类型
	private Double stkPrice;//市价
	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Double getStkChgPct() {
		return stkChgPct;
	}
	public void setStkChgPct(Double stkChgPct) {
		this.stkChgPct = stkChgPct;
	}
	public Double getStkChg() {
		return stkChg;
	}
	public void setStkChg(Double stkChg) {
		this.stkChg = stkChg;
	}
	public Object getStype() {
		return stype;
	}
	public void setStype(Object stype) {
		this.stype = stype;
	}
	public Double getStkPrice() {
		return stkPrice;
	}
	public void setStkPrice(Double stkPrice) {
		this.stkPrice = stkPrice;
	}


	

}