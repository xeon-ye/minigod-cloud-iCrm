/**
 * @Title: IMFetchGrpOrderStatusVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 下午1:48:18
 * @version v1.0
 */

public class IMFetchGrpOrderStatusVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String payChannel; // 支付渠道 W – 微信 , A – 阿里
	private Long orderId; // 直播间支付订单ID

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
