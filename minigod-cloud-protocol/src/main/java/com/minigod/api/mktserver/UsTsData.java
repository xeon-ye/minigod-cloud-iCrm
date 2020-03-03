package com.minigod.api.mktserver;

import com.minigod.api.mktinfo.vo.QuotationVO;

public class UsTsData extends QuotationVO{
	private static final long serialVersionUID = 1L;

	private Double tktVol; // tick total volume 分笔累计成交量
	private Double tktTo; // tick total turnOver 分笔累计成交金额
	
	public Double getTktVol() {
		return tktVol;
	}
	public void setTktVol(Double tktVol) {
		this.tktVol = tktVol;
	}
	public Double getTktTo() {
		return tktTo;
	}
	public void setTktTo(Double tktTo) {
		this.tktTo = tktTo;
	}
}
