/**
 * @Title: IMFetchGroupListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author chenyouhuo
 * @date 2016-6-20 下午1:04:53
 * @version v1.0
 */

public class IMGetChatRoomListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMGetChatRoomlistRVO params;

	public IMGetChatRoomlistRVO getParams() {
		return params;
	}

	public void setParams(IMGetChatRoomlistRVO params) {
		this.params = params;
	}
}
