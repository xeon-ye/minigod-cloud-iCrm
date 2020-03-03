/**
 * @Title: GSsaveGameInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-13 下午3:12:23
 * @version v1.0
 */

public class GSsaveGameInfoReqVO extends GSbaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String reqId;
	private String name;
	private String startDate;
	private String endDate;
	private Integer limitNum;
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
}
