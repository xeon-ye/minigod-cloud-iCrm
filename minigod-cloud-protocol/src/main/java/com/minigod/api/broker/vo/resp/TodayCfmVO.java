/**
 * @Title: TodayCfmVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.api.broker.vo.enums.EBrkConfirmType;
import com.minigod.api.ptf.vo.enums.EOrderDirection;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 当日成交
 * 
 * @author 余俊斌
 * @date 2015年3月16日 下午7:20:44
 * @version v1.0
 */

public class TodayCfmVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 成交编号
	private String cfmNo;
	// 委托编号
	private String ordSeq;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 股东账号
	private String stkAcc;
	// 股票代码
	private String stkCode;
	// 股票名称
	private String stkName;
	// 买卖方向
	private EOrderDirection orderBS;
	// 成交数量
	private Double cfmQty;
	// 成交价格
	private Double cfmPrice;
	// 成交金额
	private Double cfmBalance;
	// 成交类型
	private EBrkConfirmType cfmType;
	// 成交的日期
	private Date cfmDate;
	// 定位串
	private String positionStr;
	// 资金账号
	private String depositAcc;

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public String getCfmNo() {
		return cfmNo;
	}

	public void setCfmNo(String cfmNo) {
		this.cfmNo = cfmNo;
	}

	public String getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
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

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public EOrderDirection getOrderBS() {
		return orderBS;
	}

	public void setOrderBS(EOrderDirection orderBS) {
		this.orderBS = orderBS;
	}

	public Double getCfmQty() {
		return cfmQty;
	}

	public void setCfmQty(Double cfmQty) {
		this.cfmQty = cfmQty;
	}

	public Double getCfmPrice() {
		return cfmPrice;
	}

	public void setCfmPrice(Double cfmPrice) {
		this.cfmPrice = cfmPrice;
	}

	public Double getCfmBalance() {
		return cfmBalance;
	}

	public void setCfmBalance(Double cfmBalance) {
		this.cfmBalance = cfmBalance;
	}

	public EBrkConfirmType getCfmType() {
		return cfmType;
	}

	public void setCfmType(EBrkConfirmType cfmType) {
		this.cfmType = cfmType;
	}

	public Date getCfmDate() {
		return cfmDate;
	}

	public void setCfmDate(Date cfmDate) {
		this.cfmDate = cfmDate;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

}
