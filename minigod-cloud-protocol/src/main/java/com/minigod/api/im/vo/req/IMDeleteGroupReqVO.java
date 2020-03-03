/**
 * @Title: IMDeleteGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-15 下午3:14:33
 * @version v1.0
 */

public class IMDeleteGroupReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMDeleteGroupVO params;

	public IMDeleteGroupVO getParams() {
		return params;
	}

	public void setParams(IMDeleteGroupVO params) {
		this.params = params;
	}
}
