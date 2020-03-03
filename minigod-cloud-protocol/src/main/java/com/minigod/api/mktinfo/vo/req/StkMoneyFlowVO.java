/**
 * @Title: TimesharingHis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.io.Serializable;

/**
 * <code>StkMoneyFlow</code>
 * 
 * @author HUHU
 * @date 2016-10-24
 * @version v1.0
 */
public class StkMoneyFlowVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String assetId; // 资产ID
	private long ts; //时间
	private Double largeOrderIn; // 流入大单金额
	private Double midOrderIn; // 流入中单金额
	private Double smallOrderIn; // 流入小单金额
	private Double largeOrderOut; // 流出大单金额
	private Double midOrderOut; // 流出中单金额
	private Double smallOrderOut; // 流出小单金额
	private Double totalIn; // 流入净额
	private Double totalOut; // 流出净额

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

	public Double getLargeOrderIn() {
		return largeOrderIn;
	}

	public void setLargeOrderIn(Double largeOrderIn) {
		this.largeOrderIn = largeOrderIn;
	}

	public Double getMidOrderIn() {
		return midOrderIn;
	}

	public void setMidOrderIn(Double midOrderIn) {
		this.midOrderIn = midOrderIn;
	}

	public Double getSmallOrderIn() {
		return smallOrderIn;
	}

	public void setSmallOrderIn(Double smallOrderIn) {
		this.smallOrderIn = smallOrderIn;
	}

	public Double getLargeOrderOut() {
		return largeOrderOut;
	}

	public void setLargeOrderOut(Double largeOrderOut) {
		this.largeOrderOut = largeOrderOut;
	}

	public Double getMidOrderOut() {
		return midOrderOut;
	}

	public void setMidOrderOut(Double midOrderOut) {
		this.midOrderOut = midOrderOut;
	}

	public Double getSmallOrderOut() {
		return smallOrderOut;
	}

	public void setSmallOrderOut(Double smallOrderOut) {
		this.smallOrderOut = smallOrderOut;
	}

	public Double getTotalIn() {
		return totalIn;
	}

	public void setTotalIn(Double totalIn) {
		this.totalIn = totalIn;
	}

	public Double getTotalOut() {
		return totalOut;
	}

	public void setTotalOut(Double totalOut) {
		this.totalOut = totalOut;
	}
}
