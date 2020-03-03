package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
/**
 * 
 * 
 * <code>StkRealTimeVO.java<code>[实时行情数据]
 *
 * @author  Colin
 * @date 2015-1-4 上午10:12:30
 *
 */

public class StkRealTimeVO implements Serializable {

	private static final long serialVersionUID = -1091402534090453324L;

	private String assetId;//资产ID
	private long realTime;//时间戳
	private double price;//现价
	private double change; //变动
	private int status;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public double getLastPrice() {
		return price;
	}

	public void setLastPrice(double lastPrice) {
		this.price = lastPrice;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getRealTime() {
		return realTime;
	}

	public void setRealTime(long realTime) {
		this.realTime = realTime;
	}

}