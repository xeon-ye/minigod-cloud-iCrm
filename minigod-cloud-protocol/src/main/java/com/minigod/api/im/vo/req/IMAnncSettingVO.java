/**
 * @Title: IMAnncSettingVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-3 下午8:30:39
 * @version v1.0
 */

public class IMAnncSettingVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String groupId; // 群组ID
	private Integer type;
	private String announcement;// 群公告内容

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

}
