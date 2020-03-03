/**
 * @Title: ViewpointDetailVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-2 下午5:44:27
 * @version v1.0
 */

public class ViewpointDetailVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private Long viewpointId;

	public Long getViewpointId() {
		return viewpointId;
	}

	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}
}
