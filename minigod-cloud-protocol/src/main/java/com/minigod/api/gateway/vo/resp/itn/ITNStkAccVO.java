/**
 * @Title: ITNStkAccVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN股东账号VO
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午11:09:13
 * @version v1.0
 */

public class ITNStkAccVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 定位串
	private String position_str;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号
	private String stock_account;
	// 主账标志
	private String main_flag;
	// 账户类别
	private String holder_kind;
	// 股东状态
	private String holder_status;
	// 股东权限 - 3-市价委托 e-债券风险警示 g-权证交易 m-专业投资者 w-风险警示
	private String holder_rights;

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
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

	public String getMain_flag() {
		return main_flag;
	}

	public void setMain_flag(String main_flag) {
		this.main_flag = main_flag;
	}

	public String getHolder_kind() {
		return holder_kind;
	}

	public void setHolder_kind(String holder_kind) {
		this.holder_kind = holder_kind;
	}

	public String getHolder_status() {
		return holder_status;
	}

	public void setHolder_status(String holder_status) {
		this.holder_status = holder_status;
	}

	public String getHolder_rights() {
		return holder_rights;
	}

	public void setHolder_rights(String holder_rights) {
		this.holder_rights = holder_rights;
	}

}
