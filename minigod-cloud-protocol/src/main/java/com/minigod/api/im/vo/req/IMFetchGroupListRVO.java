/**
 * @Title: IMFetchGroupList.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:04:44
 * @version v1.0
 */

public class IMFetchGroupListRVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private Long clientVersion;
	private String groupType;

	public Long getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(Long clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
}
