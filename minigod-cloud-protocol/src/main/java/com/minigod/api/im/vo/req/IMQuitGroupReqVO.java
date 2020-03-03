/**
 * @Title: IMQuitGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午1:00:37
 * @version v1.0
 */

public class IMQuitGroupReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMQuitGroupVO params;

	public IMQuitGroupVO getParams() {
		return params;
	}

	public void setParams(IMQuitGroupVO params) {
		this.params = params;
	}
}
