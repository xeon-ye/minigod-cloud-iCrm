/**
 * @Title: ITNTodayOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN当日委托查询请求
 *
 * @author 余俊斌
 * @date 2015年7月2日 下午9:44:37
 * @version v1.0
 */

public class ITNTodayOrderRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 交易类别 - 限制字典子项：1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 操作控制值 - 0-查询全部委托；1-查询可撤委托；
	private String action_in;

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

	public String getAction_in() {
		return action_in;
	}

	public void setAction_in(String action_in) {
		this.action_in = action_in;
	}

}
