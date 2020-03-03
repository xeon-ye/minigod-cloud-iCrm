/**
 * @Title: IMFetchGrpOrderStatusRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 下午1:53:59
 * @version v1.0
 */

public class IMFetchGrpOrderStatusRespVO implements Serializable {
	private static final long serialVersionUID = 7313809244402897961L;
	private String businessStatus; // 业务状态 Y – 加入成功, N – 处理中
	private String displayMessage; // 显示的内容
	public String getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}
	public String getDisplayMessage() {
		return displayMessage;
	}
	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}
}
