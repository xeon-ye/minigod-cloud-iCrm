/**
 * @Title: OrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

/**
 * @description 下单响应
 * 
 * @author Jimmy
 * @date 2015-3-9 下午8:46:03
 * @version v1.0
 */

public class OrderVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 委托编号
	private String ordSeq;
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

	public String getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}

}
