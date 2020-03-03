/**
 * @Title: ITNHisOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

/**
 * @description iTN历史委托查询
 *
 * @author 余俊斌
 * @date 2015年7月3日 上午10:55:31
 * @version v1.0
 */

public class ITNHisOrderRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 开始日期
	private String start_date;
	// 到期日期
	private String end_date;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getExchange_type() {
		return exchange_type;
	}

	public void setExchange_type(String exchange_type) {
		this.exchange_type = exchange_type;
	}

	public String getStock_account() {
		return stock_account;
	}

	public void setStock_account(String stock_account) {
		this.stock_account = stock_account;
	}

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

}
