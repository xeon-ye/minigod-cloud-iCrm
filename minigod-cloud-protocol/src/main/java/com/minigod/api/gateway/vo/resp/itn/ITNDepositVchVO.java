/**
 * @Title: ITNDepositVchVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN资金流水返回
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午4:07:29
 * @version v1.0
 */

public class ITNDepositVchVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 流水序号
	private String serial_no;
	// 成交日期
	private String business_date;
	// 业务名称
	private String business_name;
	// 发生金额
	private String occur_balance;
	// 后资金额
	private String post_balance;
	// 币种类别 - 0-人民币 1-美元 2-港币
	private String money_type;
	// 发生数量
	private String occur_amount;
	// 定位串
	private String position_str;

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getBusiness_date() {
		return business_date;
	}

	public void setBusiness_date(String business_date) {
		this.business_date = business_date;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getOccur_balance() {
		return occur_balance;
	}

	public void setOccur_balance(String occur_balance) {
		this.occur_balance = occur_balance;
	}

	public String getPost_balance() {
		return post_balance;
	}

	public void setPost_balance(String post_balance) {
		this.post_balance = post_balance;
	}

	public String getMoney_type() {
		return money_type;
	}

	public void setMoney_type(String money_type) {
		this.money_type = money_type;
	}

	public String getOccur_amount() {
		return occur_amount;
	}

	public void setOccur_amount(String occur_amount) {
		this.occur_amount = occur_amount;
	}

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
	}

}
