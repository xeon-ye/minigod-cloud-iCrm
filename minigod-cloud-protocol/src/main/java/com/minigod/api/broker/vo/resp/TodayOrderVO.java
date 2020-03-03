/**
 * @Title: TodayOrderVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.api.broker.vo.enums.EBrkCanlcelFlag;
import com.minigod.api.broker.vo.enums.EBrkOrderStatus;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.ptf.vo.enums.EOrderProperty;
import com.minigod.api.ptf.vo.enums.real_stk_ord.EOrderBusType;

/**
 * @description 当日委托
 * 
 * @author Jimmy
 * @date 2015-3-14 下午2:08:12
 * @version v1.0
 */

public class TodayOrderVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 委托编号
	private String ordSeq;
	// 委托状态
	private EBrkOrderStatus ordStatus;
	// 股东账号
	private String stkAcc;
	// 股票代码
	private String stkCode;
	// 股票名称
	private String stkName;
	// 买卖标志
	private EOrderBusType ordBS;
	// 券商端买卖标志
	private String orgOrdBS;
	// 买卖属性 ： L - 限价, M - 市价
	private EOrderProperty ordProp;
	// 委托数量
	private Double ordQty;
	// 委托价格
	private Double ordPrice;
	// 成交数量
	private Double cfmQty;
	// 成交价格
	private Double cfmPrice;
	// 撤单数量
	private Double wthQty;
	// 委托日期
	private Date ordDate;
	// 分页书签
	private String positionStr;
	// 合同序号
	private String contractId;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 券商端市场代码
	private String orgExchangeType;
	// 资金账号
	private String depositAcc;
	// 撤单标志
	private EBrkCanlcelFlag wthFlag;
	// 货币
	private String currency;
	// 证券类别
	private String stkType;

	public String getStkType() {
		return stkType;
	}

	public void setStkType(String stkType) {
		this.stkType = stkType;
	}

	public Double getCfmPrice() {
		return cfmPrice;
	}

	public void setCfmPrice(Double cfmPrice) {
		this.cfmPrice = cfmPrice;
	}

	public String getOrdSeq() {
		return ordSeq;
	}

	public EOrderProperty getOrdProp() {
		return ordProp;
	}

	public void setOrdProp(EOrderProperty ordProp) {
		this.ordProp = ordProp;
	}

	public String getOrgOrdBS() {
		return orgOrdBS;
	}

	public void setOrgOrdBS(String orgOrdBS) {
		this.orgOrdBS = orgOrdBS;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}

	public EBrkOrderStatus getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(EBrkOrderStatus ordStatus) {
		this.ordStatus = ordStatus;
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

	public String getOrgExchangeType() {
		return orgExchangeType;
	}

	public void setOrgExchangeType(String orgExchangeType) {
		this.orgExchangeType = orgExchangeType;
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

	public EOrderBusType getOrdBS() {
		return ordBS;
	}

	public void setOrdBS(EOrderBusType ordBS) {
		this.ordBS = ordBS;
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

	public Double getWthQty() {
		return wthQty;
	}

	public void setWthQty(Double wthQty) {
		this.wthQty = wthQty;
	}

	public void setOrdPrice(Double ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Double getCfmQty() {
		return cfmQty;
	}

	public void setCfmQty(Double cfmQty) {
		this.cfmQty = cfmQty;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
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

	public EBrkCanlcelFlag getWthFlag() {
		return wthFlag;
	}

	public void setWthFlag(EBrkCanlcelFlag wthFlag) {
		this.wthFlag = wthFlag;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
