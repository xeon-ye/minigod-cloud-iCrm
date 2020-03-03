/**
 * @Title: IMGroupOrderVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-4 上午9:16:46
 * @version v1.0
 */

public class IMGroupOrderVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	private String groupId; //群组ID	
	private Integer qty; //购买的数量
	private String price; // 购买的价格
	private String payChannel; //支付的渠道	W – 微信, A – 支付宝
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayChannel() {
		return payChannel;
	}
	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}
}
