/**
 * @Title: IMGroupMemberSettingReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-8 下午7:24:25
 * @version v1.0
 */

public class IMGroupMemberSettingReqVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	
	private List<String> addMembers; // 新增成员的IM ID
	private List<String> deleteMembers; // 删除成员IM ID
	private String groupId; // 群组ID
	public List<String> getAddMembers() {
		return addMembers;
	}
	public void setAddMembers(List<String> addMembers) {
		this.addMembers = addMembers;
	}
	public List<String> getDeleteMembers() {
		return deleteMembers;
	}
	public void setDeleteMembers(List<String> deleteMembers) {
		this.deleteMembers = deleteMembers;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
