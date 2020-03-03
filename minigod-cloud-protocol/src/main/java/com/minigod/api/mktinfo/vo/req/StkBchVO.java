/*
 * FileName: StkDailyVO.java
 * Copyright: Copyright 2014-11-19 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

public class StkBchVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 1L;
	private Integer bchType;
	private String bchId;
	private Long startTime;
	
	public Integer getBchType() {
		return bchType;
	}
	public void setBchType(Integer bchType) {
		this.bchType = bchType;
	}
	public String getBchId() {
		return bchId;
	}
	public void setBchId(String bchId) {
		this.bchId = bchId;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
}
