/**
 * @Title: TodayOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.broker.vo.enums.EBrkWithdrawFlag;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 当日委托
 * 
 * @author Jimmy
 * @date 2015-3-14 下午2:04:37
 * @version v1.0
 */

public class TodayOrdRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 可撤单标识
	private EBrkWithdrawFlag wthFlag;
	// 指定委托号
	private String ordNo;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 股票代码
	private String stkCode;

	public EBrkWithdrawFlag getWthFlag() {
		return wthFlag;
	}

	public void setWthFlag(EBrkWithdrawFlag wthFlag) {
		this.wthFlag = wthFlag;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

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
}
