package com.minigod.api.im.vo;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * <code>Announcement</code>
 *
 * @author Jimmy
 * @date 2015-11-30 上午10:39:06
 * @version v1.0
 */
@TransferBean
public class Announcement implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer type; // 群公告类型
	private Long publishTs; // 群公告发布时间戳
	@Emoji
	private String announcement;// 群公告
	private String groupId;
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
}