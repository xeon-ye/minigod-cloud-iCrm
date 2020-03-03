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

public class StkBaseInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String assetId;// 股票资产ID
	private String stkName;// 股票名称
	private String stkCode;// 股票代码
	private Double stkChgPct;// 涨跌幅
	private String price;// 现价
	private Object stype;//证券子类型

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Object getStype() {
		return stype;
	}

	public void setStype(Object stype) {
		this.stype = stype;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}
}
