/**
 * @Title: FetchUserFriendVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-29 下午3:42:45
 * @version v1.0
 */

public class FetchUserFriendVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private FetchUserFriendReqVO params;

	public FetchUserFriendReqVO getParams() {
		return params;
	}
	public void setParams(FetchUserFriendReqVO params) {
		this.params = params;
	}
}
