/**
 * @Title: IMNewMembersReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.live.vo;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午12:56:56
 * @version v1.0
 */

public class LiveVidReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private LiveVidVO params;

	public LiveVidVO getParams() {
		return params;
	}

	public void setParams(LiveVidVO params) {
		this.params = params;
	}
}
