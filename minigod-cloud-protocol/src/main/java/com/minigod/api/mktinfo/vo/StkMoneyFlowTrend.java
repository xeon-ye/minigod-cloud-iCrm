/**
 * @Title: TimesharingHis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * <code>StkMoneyFlowTrend</code>
 * 
 * @author HUHU
 * @date 2016-10-24
 * @version v1.0
 */
public class StkMoneyFlowTrend implements Serializable {
	private static final long serialVersionUID = -5700710414043800254L;
	private long ts; // 时间
	private Double totalValue; // 净流入

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
