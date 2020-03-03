/**
 * @Title: DepositVchVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.api.broker.vo.enums.EBrkCurrencyType;

/**
 * @description 资金流水
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午4:00:23
 * @version v1.0
 */

public class DepositVchVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 交易日期
	private Date tradeDate;
	// 流水序号
	private Integer serialNo;
	// 业务标志
	private Integer busFlag;
	// 业务标志名称
	private String busName;
	// 币种
	private EBrkCurrencyType currency;
	// 发生金额
	private Double occurBalance;
	// 发生后余额
	private Double postBalance;
	// 定位串
	private String positionStr;
	// 股东账号
	private String stkAcc;
	// 资金账号
	private String depositAcc;

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getBusFlag() {
		return busFlag;
	}

	public void setBusFlag(Integer busFlag) {
		this.busFlag = busFlag;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public EBrkCurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(EBrkCurrencyType currency) {
		this.currency = currency;
	}

	public Double getOccurBalance() {
		return occurBalance;
	}

	public void setOccurBalance(Double occurBalance) {
		this.occurBalance = occurBalance;
	}

	public Double getPostBalance() {
		return postBalance;
	}

	public void setPostBalance(Double postBalance) {
		this.postBalance = postBalance;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}
}
