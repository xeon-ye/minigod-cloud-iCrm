/**
 * @Title: ITNPositionVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN持仓返回
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午4:58:07
 * @version v1.0
 */

public class ITNPositionVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 证券名称
	private String stock_name;
	// 当前数量
	private String current_amount;
	// 可用数量
	private String enable_amount;
	// 最新价
	private String last_price;
	// 成本价
	private String cost_price;
	// 盈亏金额
	private String income_balance;
	// 证券市值
	private String market_value;
	// 定位串
	private String position_str;
	// 币种类别 - 0-人民币 1-美元 2-港币
	private String money_type;

	public String getExchange_type() {
		return exchange_type;
	}

	public void setExchange_type(String exchange_type) {
		this.exchange_type = exchange_type;
	}

	public String getStock_account() {
		return stock_account;
	}

	public void setStock_account(String stock_account) {
		this.stock_account = stock_account;
	}

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getCurrent_amount() {
		return current_amount;
	}

	public void setCurrent_amount(String current_amount) {
		this.current_amount = current_amount;
	}

	public String getEnable_amount() {
		return enable_amount;
	}

	public void setEnable_amount(String enable_amount) {
		this.enable_amount = enable_amount;
	}

	public String getLast_price() {
		return last_price;
	}

	public void setLast_price(String last_price) {
		this.last_price = last_price;
	}

	public String getCost_price() {
		return cost_price;
	}

	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}

	public String getIncome_balance() {
		return income_balance;
	}

	public void setIncome_balance(String income_balance) {
		this.income_balance = income_balance;
	}

	public String getMarket_value() {
		return market_value;
	}

	public void setMarket_value(String market_value) {
		this.market_value = market_value;
	}

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
	}

	public String getMoney_type() {
		return money_type;
	}

	public void setMoney_type(String money_type) {
		this.money_type = money_type;
	}

}
