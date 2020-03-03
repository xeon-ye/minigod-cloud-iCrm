package com.minigod.api.mktmgr.vo.req;

import com.minigod.api.vo.BaseVO;


public class LogMktReqVO extends  BaseVO {

	private static final long serialVersionUID = -4795436481254306490L;

	private Long userId;//
	private Long packageId;//行情套餐ID
	private Long relationId;
	private String loginFrom;//来源平台
	private String loginIp;//登录IP
	private String stockName;//股票名称
	private String stockCode;//股票代码
	private String loginAdr;
	private String feeWay;//1-串流，2-bmp，3-点击，
	private String exchange;//美股交易市场
	
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getFeeWay() {
		return feeWay;
	}
	public void setFeeWay(String feeWay) {
		this.feeWay = feeWay;
	}
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	public String getLoginAdr() {
		return loginAdr;
	}
	public void setLoginAdr(String loginAdr) {
		this.loginAdr = loginAdr;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPackageId() {
		return packageId;
	}
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}
	public String getLoginFrom() {
		return loginFrom;
	}
	public void setLoginFrom(String loginFrom) {
		this.loginFrom = loginFrom;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
}
