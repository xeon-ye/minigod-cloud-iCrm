/**
 * @Title: AdLinkListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-28 上午10:22:17
 * @version v1.0
 */

public class AdLinkListReqVO extends AdBaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer positionGroup;
	private Integer count;
	public Integer getPositionGroup() {
		return positionGroup;
	}
	public void setPositionGroup(Integer positionGroup) {
		this.positionGroup = positionGroup;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
