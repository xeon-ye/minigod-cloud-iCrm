package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * 获取用户系统通知
 */

public class NoticeVO implements Serializable {

	private static final long serialVersionUID = 5686950467311934966L;
	private Integer noticeId;//消息ID
	private String created;//消息创建时间
	private Integer type;//类型表示  (0为 普通消息（非已处理，非待处理）//1为已处理消息//2为待处理消息)
	private Integer unread;//0为已读	1为未读
	private String title;//消息标题
	private String content;//内容

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUnread() {
		return unread;
	}

	public void setUnread(Integer unread) {
		this.unread = unread;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
