/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class BrkLogInfoRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId;
	private String message;
	public Long getPtfId() {
		return ptfId;
	}
	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
