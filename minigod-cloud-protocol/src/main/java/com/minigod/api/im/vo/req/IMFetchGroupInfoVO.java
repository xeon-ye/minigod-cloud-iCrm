/**
 * @Title: IMFetchGroupInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:03:00
 * @version v1.0
 */

public class IMFetchGroupInfoVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
