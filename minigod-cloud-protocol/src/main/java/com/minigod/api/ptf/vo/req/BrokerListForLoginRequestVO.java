package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: BrokerListForLoginRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author 余俊斌、许德佑
 * @date 2015年3月9日 下午9:30:25
 * @version v1.0
 */

public class BrokerListForLoginRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private BrokerListForLoginVO params;

	public BrokerListForLoginVO getParams() {
		return params;
	}

	public void setParams(BrokerListForLoginVO params) {
		this.params = params;
	}

}
