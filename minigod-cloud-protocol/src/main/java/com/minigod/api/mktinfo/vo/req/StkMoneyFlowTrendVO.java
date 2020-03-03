/**
 * @Title: TimesharingHis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * <code>StkMoneyFlowTrend</code>
 * 
 * @author HUHU
 * @date 2016-10-24
 * @version v1.0
 */
public class StkMoneyFlowTrendVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	private String assetId; // 资产ID
	private long ts; // 时间
	private Double totalValue; // 流入流出净额

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
}
