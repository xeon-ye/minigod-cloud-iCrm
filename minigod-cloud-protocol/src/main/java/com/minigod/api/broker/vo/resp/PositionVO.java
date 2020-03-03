/**
 * @Title: PositionVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.api.broker.vo.enums.EBrkCurrencyType;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 持仓
 * 
 * @author 余俊斌
 * @date 2015年3月17日 下午5:19:41
 * @version v1.0
 */

public class PositionVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 股票名称
	private String stkName;
	// 股票代码
	private String stkCode;
	// 当前数量
	private Double currentQty;
	// 今日买入数量
	private Double todayBuyQty;
	// 可卖数量
	private Double enableQty;
	// 卖出冻结
	private Double frzSellQty;
	// 现价
	private Double lastPrice;
	// 持仓成本价
	private Double balCostPrice;
	// 买入成本价
	private Double buyCostPrice;
	// 市值
	private Double mktVal;
	// 持仓盈亏
	private Double incomeBalance;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 分页书签
	private String positionStr;
	// 股东账号
	private String stkAcc;
	// 资金账号
	private String depositAcc;
	// 异常冻结
	private Double othFrozen;
	/** 币种 */
	private EBrkCurrencyType eBrkCurrencyType;
	
	public Double getOthFrozen() {
		return othFrozen;
	}

	public void setOthFrozen(Double othFrozen) {
		this.othFrozen = othFrozen;
	}

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

	public Double getTodayBuyQty() {
		return todayBuyQty;
	}

	public void setTodayBuyQty(Double todayBuyQty) {
		this.todayBuyQty = todayBuyQty;
	}

	public Double getFrzSellQty() {
		return frzSellQty;
	}

	public void setFrzSellQty(Double frzSellQty) {
		this.frzSellQty = frzSellQty;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public Double getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(Double currentQty) {
		this.currentQty = currentQty;
	}

	public Double getEnableQty() {
		return enableQty;
	}

	public void setEnableQty(Double enableQty) {
		this.enableQty = enableQty;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Double getBalCostPrice() {
		return balCostPrice;
	}

	public void setBalCostPrice(Double balCostPrice) {
		this.balCostPrice = balCostPrice;
	}

	public Double getBuyCostPrice() {
		return buyCostPrice;
	}

	public void setBuyCostPrice(Double buyCostPrice) {
		this.buyCostPrice = buyCostPrice;
	}

	public Double getMktVal() {
		return mktVal;
	}

	public void setMktVal(Double mktVal) {
		this.mktVal = mktVal;
	}

	public Double getIncomeBalance() {
		return incomeBalance;
	}

	public void setIncomeBalance(Double incomeBalance) {
		this.incomeBalance = incomeBalance;
	}

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

	public EBrkCurrencyType geteBrkCurrencyType() {
		return eBrkCurrencyType;
	}

	public void seteBrkCurrencyType(EBrkCurrencyType eBrkCurrencyType) {
		this.eBrkCurrencyType = eBrkCurrencyType;
	}
}
