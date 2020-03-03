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
 * @description 历史成交
 * 
 * @author 余俊斌
 * @date 2015年3月17日 下午2:15:53
 * @version v1.0
 */
public class HisCfmVO implements Serializable {

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
	private Double cfmAmount;
	// 成交类型
	private EBrkConfirmType cfmType;
	// 成交的日期
	private Date cfmDate;
	// 印花税
	private Double tax;
	// 过户费
	private Double fee;
	// 清算费
	private Double clrFee;
	// 定位串
	private String positionStr;
	// 资金账号
	private String depositAcc;
	// 委托数量
	private Double ordQty;
	// 委托价格
	private Double ordPrice;
	// 证券类别
	private String stkType;

	public String getStkType() {
		return stkType;
	}

	public void setStkType(String stkType) {
		this.stkType = stkType;
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

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
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

	public Double getCfmAmount() {
		return cfmAmount;
	}

	public void setCfmAmount(Double cfmAmount) {
		this.cfmAmount = cfmAmount;
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
