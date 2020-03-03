/**
 * @Title: IMRewardReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 *
 * @author Jimmy
 * @date 2015-11-30 上午10:28:12
 * @version v1.0
 */

public class IMRewardReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMRewardVO params;

	private String requestSrc;

	public IMRewardVO getParams() {
		return params;
	}

	public void setParams(IMRewardVO params) {
		this.params = params;
	}

	public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}
}
