/**
 * @Title: ITNDepositVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN资金查询返回
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午3:06:50
 * @version v1.0
 */

public class ITNDepositVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 币种类别 - 0-人民币 1-美元 2-港币
	private String money_type;
	// 当前余额
	private String current_balance;
	// 可用资金
	private String enable_balance;
	// 冻结资金
	private String frozen_balance;
	// 解冻资金
	private String unfrozen_balance;
	// 可取金额
	private String fetch_balance;
	// 证券市值
	private String market_value;
	// 资产值
	private String asset_balance;
	// 总资金余额
	private String fund_balance;

	public String getMoney_type() {
		return money_type;
	}

	public void setMoney_type(String money_type) {
		this.money_type = money_type;
	}

	public String getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(String current_balance) {
		this.current_balance = current_balance;
	}

	public String getEnable_balance() {
		return enable_balance;
	}

	public void setEnable_balance(String enable_balance) {
		this.enable_balance = enable_balance;
	}

	public String getFrozen_balance() {
		return frozen_balance;
	}

	public void setFrozen_balance(String frozen_balance) {
		this.frozen_balance = frozen_balance;
	}

	public String getUnfrozen_balance() {
		return unfrozen_balance;
	}

	public void setUnfrozen_balance(String unfrozen_balance) {
		this.unfrozen_balance = unfrozen_balance;
	}

	public String getFetch_balance() {
		return fetch_balance;
	}

	public void setFetch_balance(String fetch_balance) {
		this.fetch_balance = fetch_balance;
	}

	public String getMarket_value() {
		return market_value;
	}

	public void setMarket_value(String market_value) {
		this.market_value = market_value;
	}

	public String getAsset_balance() {
		return asset_balance;
	}

	public void setAsset_balance(String asset_balance) {
		this.asset_balance = asset_balance;
	}

	public String getFund_balance() {
		return fund_balance;
	}

	public void setFund_balance(String fund_balance) {
		this.fund_balance = fund_balance;
	}

}
