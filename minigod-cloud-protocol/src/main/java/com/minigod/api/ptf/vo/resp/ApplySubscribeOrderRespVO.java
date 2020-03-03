/**
 * @Title: PtfFollowCheckVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;


@TransferBean
public class ApplySubscribeOrderRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long orderId;
	
	private Object payInfo;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	

	public Object getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(Object payInfo) {
		this.payInfo = payInfo;
	}
	
	

}
