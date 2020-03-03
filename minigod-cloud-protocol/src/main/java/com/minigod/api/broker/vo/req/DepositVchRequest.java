/**
 * @Title: DepositVchRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

/**
 * @description 资金流水查询
 * 
 * @author Jimmy
 * @date 2015-3-13 下午3:30:37
 * @version v1.0
 */

public class DepositVchRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 初始时间
	private String startDate;
	// 结束时间
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
