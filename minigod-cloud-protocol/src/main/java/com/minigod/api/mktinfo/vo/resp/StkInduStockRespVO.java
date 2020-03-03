/**
 * @Title: StkLabelStockRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 行业成分股
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午9:39:03
 * @version v1.0
 */

public class StkInduStockRespVO implements Serializable {

	private static final long serialVersionUID = -6188986143860341978L;
	private String assetId;
	private String stkName;
	private String price;
	private String stkChgPct;
	private String mktVal;
	private String pe;
	private String pb;
	private String stype;
	private String status;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStkChgPct() {
		return stkChgPct;
	}

	public void setStkChgPct(String stkChgPct) {
		this.stkChgPct = stkChgPct;
	}

	public String getMktVal() {
		return mktVal;
	}

	public void setMktVal(String mktVal) {
		this.mktVal = mktVal;
	}

	public String getPe() {
		return pe;
	}

	public void setPe(String pe) {
		this.pe = pe;
	}

	public String getPb() {
		return pb;
	}

	public void setPb(String pb) {
		this.pb = pb;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
