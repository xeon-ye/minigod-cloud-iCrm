/**
 * @Title: ViewpointSelectionVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 下午1:58:33
 * @version v1.0
 */

public class MyMediaListVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	private Integer count;
	private Integer moreId;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMoreId() {
		return moreId;
	}
	public void setMoreId(Integer moreId) {
		this.moreId = moreId;
	}
}
