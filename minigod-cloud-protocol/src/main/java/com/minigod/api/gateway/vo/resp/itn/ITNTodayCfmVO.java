/**
 * @Title: ITNTodayCfmVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN当日成交
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午1:08:59
 * @version v1.0
 */

public class ITNTodayCfmVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 买卖方向
	private String entrust_bs;
	// 成交价格
	private String business_price;
	// 成交数量
	private String business_amount;
	// 成交时间
	private String business_time;
	// 成交类型 - 0-成交 2-废单
	private String real_type;
	// 处理标志 - 0-成交 2-废单
	private String real_status;
	// 委托编号
	private String entrust_no;
	// 成交金额
	private String business_balance;
	// 证券名称
	private String stock_name;
	// 成交编号
	private String business_no;
	// 定位串
	private String position_str;

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

	public String getEntrust_bs() {
		return entrust_bs;
	}

	public void setEntrust_bs(String entrust_bs) {
		this.entrust_bs = entrust_bs;
	}

	public String getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(String business_price) {
		this.business_price = business_price;
	}

	public String getBusiness_amount() {
		return business_amount;
	}

	public void setBusiness_amount(String business_amount) {
		this.business_amount = business_amount;
	}

	public String getBusiness_time() {
		return business_time;
	}

	public void setBusiness_time(String business_time) {
		this.business_time = business_time;
	}

	public String getReal_type() {
		return real_type;
	}

	public void setReal_type(String real_type) {
		this.real_type = real_type;
	}

	public String getReal_status() {
		return real_status;
	}

	public void setReal_status(String real_status) {
		this.real_status = real_status;
	}

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
	}

	public String getBusiness_balance() {
		return business_balance;
	}

	public void setBusiness_balance(String business_balance) {
		this.business_balance = business_balance;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
	}

}
