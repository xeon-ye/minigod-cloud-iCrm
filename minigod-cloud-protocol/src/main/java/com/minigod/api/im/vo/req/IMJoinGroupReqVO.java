/**
 * @Title: IMJoinGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-12 下午6:07:25
 * @version v1.0
 */

public class IMJoinGroupReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMJoinGroupVO params;

	public IMJoinGroupVO getParams() {
		return params;
	}

	public void setParams(IMJoinGroupVO params) {
		this.params = params;
	}
}
