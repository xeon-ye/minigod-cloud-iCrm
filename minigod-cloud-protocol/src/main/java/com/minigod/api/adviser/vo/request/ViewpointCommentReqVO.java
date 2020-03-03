/**
 * @Title: ViewpointCommentReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午1:54:26
 * @version v1.0
 */

public class ViewpointCommentReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private ViewpointCommentVO params;

	public ViewpointCommentVO getParams() {
		return params;
	}

	public void setParams(ViewpointCommentVO params) {
		this.params = params;
	}
}
