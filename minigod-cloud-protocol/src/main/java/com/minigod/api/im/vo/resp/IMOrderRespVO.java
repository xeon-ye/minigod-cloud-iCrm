/**
 * @Title: IMGroupOrderRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 上午9:49:24
 * @version v1.0
 */

public class IMOrderRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	private String orderId;
	private Object payInfo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Object getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(Object payInfo) {
		this.payInfo = payInfo;
	}

}
