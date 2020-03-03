/**
 * @Title: WithdrawRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 撤单
 * 
 * @author Jimmy
 * @date 2015-3-13 下午2:51:09
 * @version v1.0
 */

public class WithdrawRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 交易市场
	private EOrderExchMkt exchangeType;
	// 委托编号
	private String ordSeq;
	// 交易密码
	private String pwd;

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
