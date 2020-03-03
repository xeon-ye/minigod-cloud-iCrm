/**
 * @Title: ITNTodayCfmVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN历史成交
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午2:32:06
 * @version v1.0
 */
public class ITNHisCfmVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易日期
	private String init_date;
	// 流水序号
	private String serial_no;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 证券代码
	private String stock_name;
	// 买卖方向
	private String entrust_bs;
	// 成交价格
	private String business_price;
	// 成交时间 
	private String business_time;
	// 委托编号
	private String entrust_no;
	// 发生数量
	private String occur_amount;
	// 成交金额
	private String business_balance;
	// 定位串
	private String position_str;

	public String getInit_date() {
		return init_date;
	}

	public void setInit_date(String init_date) {
		this.init_date = init_date;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

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

	public String getBusiness_time() {
		return business_time;
	}

	public void setBusiness_time(String business_time) {
		this.business_time = business_time;
	}

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
	}

	public String getOccur_amount() {
		return occur_amount;
	}

	public void setOccur_amount(String occur_amount) {
		this.occur_amount = occur_amount;
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

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
	}

}
