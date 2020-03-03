package com.minigod.api.mktserver;

import com.minigod.api.mktinfo.vo.QuotationVO;

public class SzTsData extends QuotationVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4592107110248266933L;
	
	
	double upPrice;//涨停价
	double downPrice;//跌停价
	
	public double getUpPrice() {
		return upPrice;
	}
	public void setUpPrice(double upPrice) {
		this.upPrice = upPrice;
	}
	public double getDownPrice() {
		return downPrice;
	}
	public void setDownPrice(double downPrice) {
		this.downPrice = downPrice;
	}
	
	

}
