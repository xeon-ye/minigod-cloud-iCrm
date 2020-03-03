/**
 * @Title: ITNTodayCfmRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN当日成交查询请求
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午1:07:41
 * @version v1.0
 */

public class ITNTodayCfmRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	private String exchange_type;
	private String stock_account;
	private String stock_code;

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
