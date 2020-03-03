/**
 * @Title: IMFetchChatHistoryReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 历史聊天记录请求类
 * 
 * @author Jimmy
 * @date 2015-10-21 上午11:13:41
 * @version v1.0
 */

public class IMFetchChatHistoryReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMFetchChatHistoryVO params;

	public IMFetchChatHistoryVO getParams() {
		return params;
	}

	public void setParams(IMFetchChatHistoryVO params) {
		this.params = params;
	}
}
