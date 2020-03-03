/*
 * FileName: PeriodVO.java
 * Copyright: Copyright 2014-10-24 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import java.util.List;

import com.minigod.api.ptf.vo.req.PtfInfoVO.StockQty;
import com.minigod.api.vo.BaseVO;

/**
 * <code>PeriodVO<code> 历史指数回算的收益率 
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-10-24)
 *
 */
public class YieldVO extends BaseVO{
	private static final long serialVersionUID = 5615430110372269038L;
	/** 1表示一年数据*/
	private Integer period;
	/** 各个资产的股数 */
	private List<StockQty> stks;

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public List<StockQty> getStks() {
		return stks;
	}

	public void setStks(List<StockQty> stks) {
		this.stks = stks;
	}
}
