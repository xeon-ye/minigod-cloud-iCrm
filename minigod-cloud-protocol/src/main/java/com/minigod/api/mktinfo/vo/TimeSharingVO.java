package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class TimeSharingVO implements Serializable {

	private static final long serialVersionUID = -1091402534090453324L;

	private String assetId;//资产ID
	private String date;//日期 yyyy-MM-dd
	private String time;//分时时间 HH:mm:00
	private long dateTime;//时间戳
	private double lastPrice;//现价
	private double prevClose; //前收市价
	private double open;//开市价
	private double high;//最高价
	private double low;//最低价
	private double turnOver;//当前单位时间(分钟)内成交额
	private double volume;//当前单位时间(分钟)内成交量
	private double avgPrice; // 均价

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public double getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(double prevClose) {
		this.prevClose = prevClose;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
}
