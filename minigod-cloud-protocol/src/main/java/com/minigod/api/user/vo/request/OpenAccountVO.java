/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 开户数据
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class OpenAccountVO implements Serializable{

	private static final long serialVersionUID = 3142739691637091767L;

	private String clientId;
	private String userId;
	private Date applyDate;
	private Date fillDataDate;
	private Date witnessDate;
	private Date openDate;
	private Date activeDate;
	private String clientSelfSwitch;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getFillDataDate() {
		return fillDataDate;
	}

	public void setFillDataDate(Date fillDataDate) {
		this.fillDataDate = fillDataDate;
	}

	public Date getWitnessDate() {
		return witnessDate;
	}

	public void setWitnessDate(Date witnessDate) {
		this.witnessDate = witnessDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getClientSelfSwitch() {
		return clientSelfSwitch;
	}

	public void setClientSelfSwitch(String clientSelfSwitch) {
		this.clientSelfSwitch = clientSelfSwitch;
	}
}
