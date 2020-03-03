/**
 * @Title: ITNStkAccRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN股东账号查询请求
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午10:17:31
 * @version v1.0
 */

public class ITNStkAccRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;

	public String getExchange_type() {
		return exchange_type;
	}

	public void setExchange_type(String exchange_type) {
		this.exchange_type = exchange_type;
	}

}
