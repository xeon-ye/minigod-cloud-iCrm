/**
 * @Title: GXOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

import java.io.Serializable;
import java.util.List;

/**
 * @description 批量下单
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:48:30
 * @version v1.0
 */

public class GXMultiOrderRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 客户端随机码
	private String id;
	// 多笔委托
	private List<Order> orders;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public static class Order implements Serializable {
		private static final long serialVersionUID = 1L;
		// 交易市场
		private String market;
		// 股东代码
		private String secuid;
		// 证券代码
		private String stkcode;
		// 买卖类别
		private String bsflag;
		// 价格
		private String price;
		// 数量
		private String qty;
		// 委托批号
		private String ordergroup;
		// 外部银行
		private String bankcode;
		// 备注信息
		private String remark;
		// 融资产品标识
		private String creditid;
		// 特殊委托类型
		private String creditflag;
		// 随机串
		private String randstr;
		// 客户端时间
		private String time;

		public String getMarket() {
			return market;
		}

		public void setMarket(String market) {
			this.market = market;
		}

		public String getSecuid() {
			return secuid;
		}

		public void setSecuid(String secuid) {
			this.secuid = secuid;
		}

		public String getStkcode() {
			return stkcode;
		}

		public void setStkcode(String stkcode) {
			this.stkcode = stkcode;
		}

		public String getBsflag() {
			return bsflag;
		}

		public void setBsflag(String bsflag) {
			this.bsflag = bsflag;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getQty() {
			return qty;
		}

		public void setQty(String qty) {
			this.qty = qty;
		}

		public String getOrdergroup() {
			return ordergroup;
		}

		public void setOrdergroup(String ordergroup) {
			this.ordergroup = ordergroup;
		}

		public String getBankcode() {
			return bankcode;
		}

		public void setBankcode(String bankcode) {
			this.bankcode = bankcode;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getCreditid() {
			return creditid;
		}

		public void setCreditid(String creditid) {
			this.creditid = creditid;
		}

		public String getCreditflag() {
			return creditflag;
		}

		public void setCreditflag(String creditflag) {
			this.creditflag = creditflag;
		}

		public String getRandstr() {
			return randstr;
		}

		public void setRandstr(String randstr) {
			this.randstr = randstr;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

	}
}
