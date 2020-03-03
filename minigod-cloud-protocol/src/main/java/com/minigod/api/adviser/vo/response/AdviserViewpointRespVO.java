/**
 * @Title: AdviserViewpointRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-2 下午4:40:27
 * @version v1.0
 */

public class AdviserViewpointRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long viewpointId;

	public Long getViewpointId() {
		return viewpointId;
	}

	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}
}
