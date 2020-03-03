/**
 * @Title: AdviserViewpointDetailReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 上午9:43:29
 * @version v1.0
 */

public class AdviserViewpointDetailReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long viewpointId;

	public Long getViewpointId() {
		return viewpointId;
	}

	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}
}
