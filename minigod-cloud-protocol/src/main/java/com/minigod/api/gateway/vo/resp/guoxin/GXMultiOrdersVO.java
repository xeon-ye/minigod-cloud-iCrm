/**
 * @Title: GXMultiOrdersVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

/**
 * @description 批量下单的响应
 * 
 * @author Jimmy
 * @date 2015-3-18 下午3:49:41
 * @version v1.0
 */

public class GXMultiOrdersVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 合同号
	private String orderid;
	// 委托的编号
	private String ordersno;
	// 交易市场
	private String market;
	// 股票代码
	private String stkcode;
	// 错误码
	private Integer orgcode;
	// 错误信息
	private String orgmsg;

	private String status;
	
	public String getOrdersno() {
		return ordersno;
	}

	public void setOrdersno(String ordersno) {
		this.ordersno = ordersno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(Integer orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgmsg() {
		return orgmsg;
	}

	public void setOrgmsg(String orgmsg) {
		this.orgmsg = orgmsg;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
