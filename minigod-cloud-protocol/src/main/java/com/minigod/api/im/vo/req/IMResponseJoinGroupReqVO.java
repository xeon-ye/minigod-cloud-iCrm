/**
 * @Title: IMResponseJoinGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-13 下午1:14:09
 * @version v1.0
 */

public class IMResponseJoinGroupReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMResponseJoinGroupVO params;

	public IMResponseJoinGroupVO getParams() {
		return params;
	}

	public void setParams(IMResponseJoinGroupVO params) {
		this.params = params;
	}
	
}
