/**
 * @Title: DepositVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.api.broker.vo.enums.EBrkCurrencyType;

/**
 * @description 资金查询
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午2:44:12
 * @version v1.0
 */

public class DepositVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 币种类型
	private EBrkCurrencyType currency;
	// 总资产
	private Double assetBalance;
	// 资金余额
	private Double currentBlance;
	// 可用资金
	private Double enableBlance;
	// 可取金额
	private Double fetchBlance;
	// 股票市值
	private Double stkVal;
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

	public EBrkCurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(EBrkCurrencyType currency) {
		this.currency = currency;
	}

	public Double getAssetBalance() {
		return assetBalance;
	}

	public void setAssetBalance(Double assetBalance) {
		this.assetBalance = assetBalance;
	}

	public Double getCurrentBlance() {
		return currentBlance;
	}

	public void setCurrentBlance(Double currentBlance) {
		this.currentBlance = currentBlance;
	}

	public Double getEnableBlance() {
		return enableBlance;
	}

	public void setEnableBlance(Double enableBlance) {
		this.enableBlance = enableBlance;
	}

	public Double getFetchBlance() {
		return fetchBlance;
	}

	public void setFetchBlance(Double fetchBlance) {
		this.fetchBlance = fetchBlance;
	}

	public Double getStkVal() {
		return stkVal;
	}

	public void setStkVal(Double stkVal) {
		this.stkVal = stkVal;
	}
}
