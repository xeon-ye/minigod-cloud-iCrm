/**
 * @Title: ViewpointLikesReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午4:17:02
 * @version v1.0
 */

public class ViewpointLikesReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private ViewpointLikesVO params;

	public ViewpointLikesVO getParams() {
		return params;
	}

	public void setParams(ViewpointLikesVO params) {
		this.params = params;
	}
}
