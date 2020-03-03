package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class PcStkSummaryVO extends StkSummaryVO implements Serializable {
	/**
	 * PC版股票概要信息
	 */
	private static final long serialVersionUID = 8173159973823660757L;
	private double lastPrice;//现价
	private double prevClose; //昨收价
	private double open;//今开价
	private double highPrice;//最高价
	private double lowPrice;//最低价
	private double turnOver;//成交额
	private double volume;//成交量
	private double hardenPrice;//涨停价
	private double stopPrice;//跌停价
	private Double eps; 		 //每股收益
	private Double bps; 		 //每股净资产
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
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
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
	public double getHardenPrice() {
		return hardenPrice;
	}
	public void setHardenPrice(double hardenPrice) {
		this.hardenPrice = hardenPrice;
	}
	public double getStopPrice() {
		return stopPrice;
	}
	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}
	public Double getEps() {
		return eps;
	}
	public void setEps(Double eps) {
		this.eps = eps;
	}
	public Double getBps() {
		return bps;
	}
	public void setBps(Double bps) {
		this.bps = bps;
	}

}
