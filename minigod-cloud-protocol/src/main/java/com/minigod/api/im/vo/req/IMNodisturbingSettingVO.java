/**
 * @Title: IMNodisturbingSettingVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-12 下午4:12:07
 * @version v1.0
 */
public class IMNodisturbingSettingVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String groupId;
	private Long friendUserId;
	private Integer isNodisturbing;//是否免打扰,1是0否

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getIsNodisturbing() {
		return isNodisturbing;
	}

	public void setIsNodisturbing(Integer isNodisturbing) {
		this.isNodisturbing = isNodisturbing;
	}

	public Long getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(Long friendUserId) {
		this.friendUserId = friendUserId;
	}
}
