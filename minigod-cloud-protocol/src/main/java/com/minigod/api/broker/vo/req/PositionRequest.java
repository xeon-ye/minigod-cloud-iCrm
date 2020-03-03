/**
 * @Title: PositionRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 持仓查询请求
 * 
 * @author 余俊斌
 * @date 2015年3月17日 下午5:20:46
 * @version v1.0
 */

public class PositionRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 股票代码
	private String stkCode;
	// 股东号
	private String stkAcc;

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}
}
