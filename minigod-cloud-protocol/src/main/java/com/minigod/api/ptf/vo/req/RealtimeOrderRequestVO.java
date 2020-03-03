/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 组合委托请求值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */

public class RealtimeOrderRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private RealtimeOrderVO params;

	public RealtimeOrderVO getParams() {
		return params;
	}

	public void setParams(RealtimeOrderVO params) {
		this.params = params;
	}
	
}
