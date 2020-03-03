/**
 * @Title: IMNewMembersVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午12:57:08
 * @version v1.0
 */
@TransferBean
public class IMAddNewMembersViaQNUserVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<Long> userIds; // 成员的用户 ID

	private String groupId; // 群组ID

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}
}
