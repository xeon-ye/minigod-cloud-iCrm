/**
 * @Title: GXTodayCmfRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;


/**
 * @description 当日成交请求
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:42:56
 * @version v1.0
 */

public class GXTodayCmfRequest extends  GXRequest {

	private static final long serialVersionUID = 1L;
	// 交易市场
	private String market;
	// 证券代码
	private String stkcode;
	// 委托序号
	private String ordersno;
	// 外部银行
	private String bankcode;
	// 客户习惯
	private String operhabit;
	// 查询方向
	private String qryflag;

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

	public String getOrdersno() {
		return ordersno;
	}

	public void setOrdersno(String ordersno) {
		this.ordersno = ordersno;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
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
}
