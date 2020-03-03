/**
 * @Title: FetchGroupFriendListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-29 下午3:11:29
 * @version v1.0
 */

public class FetchGroupFriendListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private GroupFriendListReqVO params;

	public GroupFriendListReqVO getParams() {
		return params;
	}

	public void setParams(GroupFriendListReqVO params) {
		this.params = params;
	}
}
