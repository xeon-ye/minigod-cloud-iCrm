/**
 * @Title: GrpReqUnreadCount.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-12-2 下午5:42:53
 * @version v1.0
 */

public class GrpReqUnreadCountVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer count = 0;
	private Integer maxGroupReqId;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMaxGroupReqId() {
		return maxGroupReqId;
	}
	public void setMaxGroupReqId(Integer maxGroupReqId) {
		this.maxGroupReqId = maxGroupReqId;
	}
}
