/**
 * @Title: ITNWithdrawRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN撤单请求
 *
 * @author 余俊斌
 * @date 2015年7月2日 下午9:25:04
 * @version v1.0
 */

public class ITNWithdrawRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 委托编号
	private String entrust_no;
	// 证券账号
	private String stock_account;
	// 委托日期
	private String entrust_date;

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
	}

	public String getStock_account() {
		return stock_account;
	}

	public void setStock_account(String stock_account) {
		this.stock_account = stock_account;
	}

	public String getEntrust_date() {
		return entrust_date;
	}

	public void setEntrust_date(String entrust_date) {
		this.entrust_date = entrust_date;
	}

}
