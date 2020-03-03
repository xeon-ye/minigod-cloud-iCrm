/**
 * @Title: TodayOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 历史委托
 * 
 * @author Jimmy
 * @date 2015-3-14 下午2:04:37
 * @version v1.0
 */

public class HisOrdRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	// 市场代码
	private EOrderExchMkt exchangeType;

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

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
