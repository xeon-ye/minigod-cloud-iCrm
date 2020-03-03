/**
 * @Title: IMRewardVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.im.enums.EPayBusCode;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-30 上午10:28:48
 * @version v1.0
 */

public class IMRewardVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private EPayBusCode rewardType; // 打赏的类型 REWD001–直播群打赏,REWD002–观点打赏
	private String targetId; // 打赏的目标ID rewardType = REWD001 时，此字段代表群组的ID;
								// rewardType = REWD001时，此字段代表观点的ID;
	private String amount; // 打赏的金额
	private String payChannel; // 支付的渠道 String W – 微信, A – 支付宝

	private String uuid;

	private String orderId;

	private String clientIp;

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}
	
	public EPayBusCode getRewardType() {
		return rewardType;
	}

	public void setRewardType(EPayBusCode rewardType) {
		this.rewardType = rewardType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
}
