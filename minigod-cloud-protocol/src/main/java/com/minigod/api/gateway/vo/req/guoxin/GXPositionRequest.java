/**
 * @Title: GXPortfolio.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 持仓查询
 * 
 * @author Jimmy
 * @date 2015-3-12 上午9:48:39
 * @version v1.0
 */

public class GXPositionRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 市场
	private String market;
	// 证券代码
	private String stkcode;
	// 客户习惯
	private String operhabit;
	// 查询方向
	private String qryflag;
	// 业务标志
	private String busiflag;

	public String getBusiflag() {
		return busiflag;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getStkcode() {
		return stkcode;
	}

	public void setStkcode(String stkcode) {
		this.stkcode = stkcode;
	}

	public String getOperhabit() {
		return operhabit;
	}

	public void setOperhabit(String operhabit) {
		this.operhabit = operhabit;
	}

	public String getQryflag() {
		return qryflag;
	}

	public void setQryflag(String qryflag) {
		this.qryflag = qryflag;
	}

	public void setBusiflag(String busiflag) {
		this.busiflag = busiflag;
	}

}
