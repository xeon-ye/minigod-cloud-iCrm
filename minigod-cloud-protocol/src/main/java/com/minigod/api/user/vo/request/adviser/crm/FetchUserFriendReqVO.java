/**
 * @Title: UserFriendReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-2 上午10:07:57
 * @version v1.0
 */

public class FetchUserFriendReqVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	private Integer groupId;
	private String imGroupId;
	private Integer userId;
	private Integer readVersion;
	private Integer limitNum;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getReadVersion() {
		return readVersion;
	}

	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImGroupId() {
		return imGroupId;
	}

	public void setImGroupId(String imGroupId) {
		this.imGroupId = imGroupId;
	}
}
