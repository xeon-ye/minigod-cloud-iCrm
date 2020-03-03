/**
 * @Title: TodayCfmRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 当日成交请求
 *
 * @author 余俊斌
 * @date 2015年3月16日 下午7:37:13
 * @version v1.0
 */

public class TodayCfmRequest extends SNRequest {

	private static final long serialVersionUID = 1L;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 股票代码
	private String stkCod;

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getStkCod() {  
		return stkCod;
	}

	public void setStkCod(String stkCod) {
		this.stkCod = stkCod;
	}

}
