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
public class MktinfoInnerStockVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5723748465093822077L;
	private String stkName;
	private String assetId;
	private Double stkChgPct;
	private Object stype;//证券子类型

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

	public Object getStype() {
		return stype;
	}

	public void setStype(Object stype) {
		this.stype = stype;
	}
	
	

}