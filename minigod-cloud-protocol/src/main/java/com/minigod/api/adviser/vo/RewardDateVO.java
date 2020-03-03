/**
 * @Title: RewardDateVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-3 下午8:48:29
 * @version v1.0
 */

public class RewardDateVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String payDate;
	private Double dateIncome;
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public Double getDateIncome() {
		return dateIncome;
	}
	public void setDateIncome(Double dateIncome) {
		this.dateIncome = dateIncome;
	}
}
