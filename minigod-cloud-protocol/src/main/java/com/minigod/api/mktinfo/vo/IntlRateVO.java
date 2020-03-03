package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class IntlRateVO implements Serializable{

	private static final long serialVersionUID = -274264580177627059L;
	private String fromCcy;//源货币种类 
	private String toCcy;//目标货币种类
	
	private double bidRate;//参考汇率买入价 
	private double offerRate;//参考汇率卖出价
	private double midPointRate;//参考汇率中间价
	
	public String getFromCcy() {
		return fromCcy;
	}
	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}
	public String getToCcy() {
		return toCcy;
	}
	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}
	public double getBidRate() {
		return bidRate;
	}
	public void setBidRate(double bidRate) {
		this.bidRate = bidRate;
	}
	public double getOfferRate() {
		return offerRate;
	}
	public void setOfferRate(double offerRate) {
		this.offerRate = offerRate;
	}
	public double getMidPointRate() {
		return midPointRate;
	}
	public void setMidPointRate(double midPointRate) {
		this.midPointRate = midPointRate;
	}
	
	
	
}
