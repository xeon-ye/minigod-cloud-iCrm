/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 委托详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */

public class OrderDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private OrderDetailVO params;

	public OrderDetailVO getParams() {
		return params;
	}

	public void setParams(OrderDetailVO params) {
		this.params = params;
	}
	
}
