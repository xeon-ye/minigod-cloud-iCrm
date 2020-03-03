/**
 * @Title: IMFetchGroupRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 下午12:16:17
 * @version v1.0
 */

public class IMFetchGroupRequestVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private Long groupRequestId;

	private Integer count = 20;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getGroupRequestId() {
		return groupRequestId;
	}

	public void setGroupRequestId(Long groupRequestId) {
		this.groupRequestId = groupRequestId;
	}

}
