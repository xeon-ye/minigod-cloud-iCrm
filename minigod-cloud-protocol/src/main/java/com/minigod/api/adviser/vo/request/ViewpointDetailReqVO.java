/**
 * @Title: ViewpointDetailReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-2 下午5:15:12
 * @version v1.0
 */

public class ViewpointDetailReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private ViewpointDetailVO params;

	public ViewpointDetailVO getParams() {
		return params;
	}

	public void setParams(ViewpointDetailVO params) {
		this.params = params;
	}
}
