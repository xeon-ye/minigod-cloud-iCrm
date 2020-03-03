/**
 * @Title: IMDeleteNewMembersVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午12:59:30
 * @version v1.0
 */

public class IMDeleteMembersVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private List<String> members; // 成员的IM ID
	
	private String groupId; // 群组ID

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}
}
