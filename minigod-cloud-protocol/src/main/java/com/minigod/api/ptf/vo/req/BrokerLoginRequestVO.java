/**
 * @Title: BrokerLoginRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 券商登录请求类
 * @author 谢尚河
 * @date 2015-7-7 上午9:10:18
 * @version v1.0
 */

public class BrokerLoginRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private BrokerLoginVO params;

	public BrokerLoginVO getParams() {
		return params;
	}

	public void setParams(BrokerLoginVO params) {
		this.params = params;
	}

}
