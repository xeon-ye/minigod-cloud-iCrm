/**
 * @Title: IMJoinGroupVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-12 下午6:07:50
 * @version v1.0
 */

public class IMJoinGroupVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String groupId;
	
	private String fromGroupId;
	
	private String groupType;
	
	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getFromGroupId() {
		return fromGroupId;
	}

	public void setFromGroupId(String fromGroupId) {
		this.fromGroupId = fromGroupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
