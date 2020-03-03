/**
 * @Title: TodayCfmRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 历史成交请求
 *
 * @author 余俊斌
 * @date 2015年3月17日 下午2:13:27
 * @version v1.0
 */
public class HisCfmRequest extends SNRequest {

	private static final long serialVersionUID = 1L;
	// 市场代码
	private EOrderExchMkt exchangeType;
	// 股票代码
	private String stkCod;
	// 开始日期
	private String startDate;
	// 结束日期
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

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getStkCod() {
		return stkCod;
	}

	public void setStkCod(String stkCod) {
		this.stkCod = stkCod;
	}

}
