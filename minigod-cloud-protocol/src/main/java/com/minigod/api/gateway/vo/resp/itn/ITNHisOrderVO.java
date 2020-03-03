/**
 * @Title: ITNTodayOrderVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;


/**
 * @description iTN历史委托查询返回
 *
 * @author 余俊斌
 * @date 2015年7月3日 上午11:06:43
 * @version v1.0
 */
public class ITNHisOrderVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// 委托编号
	private String entrust_no;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 买卖方向
	private String entrust_bs;
	// 委托价格
	private String entrust_price;
	// 委托数量
	private String entrust_amount;
	// 成交数量
	private String business_amount;
	// 成交价格
	private String business_price;
	// 申请编号
	private String report_no;
	// 申报时间
	private String report_time;
	// 委托类别 - 0-委托 2-撤单 3-补单
	private String entrust_type;
	// 委托状态 - 0-未报 1-待报 2-已报 3-已报待撤 4-部成待撤 6-已撤 7-部成 8-已成 9-废单
	private String entrust_status;
	// 委托时间
	private String entrust_time;
	// 委托日期
	private String entrust_date;
	// 证券名称
	private String stock_name;
	// 定位串
	private String position_str;

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
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

	public String getEntrust_price() {
		return entrust_price;
	}

	public void setEntrust_price(String entrust_price) {
		this.entrust_price = entrust_price;
	}

	public String getEntrust_amount() {
		return entrust_amount;
	}

	public void setEntrust_amount(String entrust_amount) {
		this.entrust_amount = entrust_amount;
	}

	public String getBusiness_amount() {
		return business_amount;
	}

	public void setBusiness_amount(String business_amount) {
		this.business_amount = business_amount;
	}

	public String getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(String business_price) {
		this.business_price = business_price;
	}

	public String getReport_no() {
		return report_no;
	}

	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}

	public String getEntrust_type() {
		return entrust_type;
	}

	public void setEntrust_type(String entrust_type) {
		this.entrust_type = entrust_type;
	}

	public String getEntrust_status() {
		return entrust_status;
	}

	public void setEntrust_status(String entrust_status) {
		this.entrust_status = entrust_status;
	}

	public String getEntrust_time() {
		return entrust_time;
	}

	public void setEntrust_time(String entrust_time) {
		this.entrust_time = entrust_time;
	}

	public String getEntrust_date() {
		return entrust_date;
	}

	public void setEntrust_date(String entrust_date) {
		this.entrust_date = entrust_date;
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
