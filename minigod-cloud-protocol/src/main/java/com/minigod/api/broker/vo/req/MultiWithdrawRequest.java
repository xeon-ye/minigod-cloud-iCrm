/**
 * @Title: MultiOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;

import java.util.List;

/**
 * @description 批量撤单请求
 *
 * @author 余俊斌
 * @date 2015年7月6日 下午8:39:17
 * @version v1.0
 */

public class MultiWithdrawRequest extends SNRequest {

	private static final long serialVersionUID = 1L;
	// 撤单请求
	List<WithdrawRequest> orders;

	public List<WithdrawRequest> getOrders() {
		return orders;
	}

	public void setOrders(List<WithdrawRequest> orders) {
		this.orders = orders;
	}

}
