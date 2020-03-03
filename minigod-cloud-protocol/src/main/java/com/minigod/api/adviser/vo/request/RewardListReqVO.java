/**
 * @Title: RewardListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-3 下午8:13:42
 * @version v1.0
 */

public class RewardListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private RewardListVO params;

	public RewardListVO getParams() {
		return params;
	}

	public void setParams(RewardListVO params) {
		this.params = params;
	}
}
