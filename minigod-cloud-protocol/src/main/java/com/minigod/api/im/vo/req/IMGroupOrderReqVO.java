/**
 * @Title: IMGroupOrderReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 上午9:08:47
 * @version v1.0
 */

public class IMGroupOrderReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMGroupOrderVO params;

	public IMGroupOrderVO getParams() {
		return params;
	}

	public void setParams(IMGroupOrderVO params) {
		this.params = params;
	}
}
