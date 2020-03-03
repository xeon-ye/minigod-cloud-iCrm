package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;


@TransferBean
public class ConfirmPtfPayStatusRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static enum BusinessStatus{
		/**
		 * 未处理
		 */
		Y,
		/**
		 * 待处理
		 */
		N,
	}
	

	
	@TransferID
	private Long ptfId;
	
	private String displayMessage;
	
	private BusinessStatus businessStatus;

	
	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public BusinessStatus getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(BusinessStatus businessStatus) {
		this.businessStatus = businessStatus;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
