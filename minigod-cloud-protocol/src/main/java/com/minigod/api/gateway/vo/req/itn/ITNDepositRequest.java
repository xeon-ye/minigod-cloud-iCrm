/**
 * @Title: ITNDepositRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN资金查询请求
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午3:05:46
 * @version v1.0
 */

public class ITNDepositRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 币种类别
	private String money_type;

	public String getMoney_type() {
		return money_type;
	}

	public void setMoney_type(String money_type) {
		this.money_type = money_type;
	}

}
