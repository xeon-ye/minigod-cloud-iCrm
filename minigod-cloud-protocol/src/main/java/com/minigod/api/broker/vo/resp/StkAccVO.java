/**
 * @Title: StkAccVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 股东账号
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午5:44:28
 * @version v1.0
 */

public class StkAccVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 券商段原始市场代码
	private String brkExchType;
	// 股东账号
	private String stkAcc;
	// 客户代码
	private String custId;
	// 开户日期
	private String openDate;
	// 资金账号
	private String depositAcc;

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getBrkExchType() {
		return brkExchType;
	}

	public void setBrkExchType(String brkExchType) {
		this.brkExchType = brkExchType;
	}
}
