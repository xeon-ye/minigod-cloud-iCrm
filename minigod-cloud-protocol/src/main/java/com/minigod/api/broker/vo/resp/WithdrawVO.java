/**
 * @Title: WithdrawVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

/**
 * @description 撤单
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午4:32:23
 * @version v1.0
 */

public class WithdrawVO implements Serializable {
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

	private static final long serialVersionUID = 1L;
}
