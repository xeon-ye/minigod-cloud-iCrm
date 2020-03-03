/**
 * @Title: StkAccRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 股东账号查询
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午5:46:09
 * @version v1.0
 */

public class StkAccRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 市场代码
	private EOrderExchMkt exchangeType;

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}
}
