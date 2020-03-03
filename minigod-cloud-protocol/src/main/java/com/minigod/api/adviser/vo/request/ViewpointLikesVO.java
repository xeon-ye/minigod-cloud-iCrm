/**
 * @Title: ViewpointLikesVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午4:18:01
 * @version v1.0
 */
public class ViewpointLikesVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private Long viewpointId;
	private Integer count;
	private Integer readId;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getReadId() {
		return readId;
	}

	public void setReadId(Integer readId) {
		this.readId = readId;
	}

	public Long getViewpointId() {
		return viewpointId;
	}

	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}
}
