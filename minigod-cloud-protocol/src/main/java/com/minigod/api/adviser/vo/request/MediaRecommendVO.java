/**
 * @Title: ViewpointSelectionVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 下午1:58:33
 * @version v1.0
 */
@TransferBean
public class MediaRecommendVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	private Integer count;
	@TransferID
	private Long userId;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
