/**
 * @Title: IMFetchAnncRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午4:52:51
 * @version v1.0
 */

public class IMFetchAnncRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long publishTs; // 发布时间戳
	private Integer type; // 群公告类型
	private String announcement; // 公告
	private String groupId;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Long getPublishTs() {
		return publishTs;
	}

	public void setPublishTs(Long publishTs) {
		this.publishTs = publishTs;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
