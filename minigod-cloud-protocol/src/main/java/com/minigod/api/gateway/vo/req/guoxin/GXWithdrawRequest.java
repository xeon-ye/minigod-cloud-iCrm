/**
 * @Title: GXWithdrawRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 撤单
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:52:38
 * @version v1.0
 */

public class GXWithdrawRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 委托日期
	private String orderdate;
	// 委托序号
	private String ordersno;
	// 证券交易市场
	private String market;
	// 证券代码
	private String stkcode;
	// 签名
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdersno() {
		return ordersno;
	}

	public void setOrdersno(String ordersno) {
		this.ordersno = ordersno;
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
}
