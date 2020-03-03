/**
 * @Title: DepositVchVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.api.broker.vo.enums.EBrkBusinessType;
import com.minigod.api.broker.vo.enums.EBrkCurrencyType;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 交割单
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午4:00:23
 * @version v1.0
 */

public class DeliverVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 交易日期
	private Date tradeDate;
	// 股票名称
	private String stkName;
	// 成交数量
	private Double cfmQty;
	// 成交价格
	private Double cfmPrice;
	// 业务类型
	private EBrkBusinessType buinessType;
	// 发生金额
	private Double occurBalance;
	// 发生后余额
	private Double postBalance;
	// 币种
	private EBrkCurrencyType currency;
	// 委托日期
	private Date ordDate;
	// 股票代码
	private String stkCode;
	// 定位串
	private String positionStr;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 资金账号
	private String depositAcc;
	// 清算日期
	private Date clrDate;
	// 股东账号
	private String stkAcc;
	// 委托数量
	private Double ordQty;
	// 委托价格
	private Double ordPrice;
	// 印花税
	private Double tax;
	// 过户费
	private Double fee;
	// 清算费
	private Double clrFee;
	// 交易规费
	private Double exchangeFee;
	// 委托编号
	private String ordSeq;

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
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

	public EBrkBusinessType getBuinessType() {
		return buinessType;
	}

	public void setBuinessType(EBrkBusinessType buinessType) {
		this.buinessType = buinessType;
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

	public EBrkCurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(EBrkCurrencyType currency) {
		this.currency = currency;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public Date getClrDate() {
		return clrDate;
	}

	public void setClrDate(Date clrDate) {
		this.clrDate = clrDate;
	}

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public Double getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(Double ordQty) {
		this.ordQty = ordQty;
	}

	public Double getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(Double ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getClrFee() {
		return clrFee;
	}

	public void setClrFee(Double clrFee) {
		this.clrFee = clrFee;
	}

	public Double getExchangeFee() {
		return exchangeFee;
	}

	public void setExchangeFee(Double exchangeFee) {
		this.exchangeFee = exchangeFee;
	}

	public String getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}

}
