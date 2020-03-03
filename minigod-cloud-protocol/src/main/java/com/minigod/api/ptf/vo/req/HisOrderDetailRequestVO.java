/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 交易历史详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */

public class HisOrderDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private HisOrderDetailVO params;

	public HisOrderDetailVO getParams() {
		return params;
	}

	public void setParams(HisOrderDetailVO params) {
		this.params = params;
	}
	
}
