/**
 * @Title: IMNewMembersReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.live.vo;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午12:56:56
 * @version v1.0
 */

public class LiveNoticeReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private LiveNoticeVO params;

	public LiveNoticeVO getParams() {
		return params;
	}

	public void setParams(LiveNoticeVO params) {
		this.params = params;
	}
}
