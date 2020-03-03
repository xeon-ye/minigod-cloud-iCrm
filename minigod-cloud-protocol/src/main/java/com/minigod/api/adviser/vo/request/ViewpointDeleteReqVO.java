/**
 * @Title: ViewpointDeleteReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午7:44:49
 * @version v1.0
 */

public class ViewpointDeleteReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private ViewpointDeleteVO params;

	public ViewpointDeleteVO getParams() {
		return params;
	}

	public void setParams(ViewpointDeleteVO params) {
		this.params = params;
	}
}
