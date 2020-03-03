/**
 * @Title: IMFetchAnnouncementVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午4:50:35
 * @version v1.0
 */

public class IMFetchAnnouncementVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
