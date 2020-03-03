/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-2-24 下午1:15:07
 * @version v1.0
 */

public class PushPtfNodeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long noteId;// 观点ID
	private String userIcon;// 发表人头像地址
	private Integer userType;// 发表人用户类型
	private String title;// 标题
	private String desc;// 摘要
	private Integer centerDesc;// 摘要是否居中，0，不居中 ，其他居中
	private Long fromUserId;// 发表人的用户ID
	private String fromImId;// 发表人的环信ID
	private String fromNickname;// 发表人的昵称

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getCenterDesc() {
		return centerDesc;
	}

	public void setCenterDesc(Integer centerDesc) {
		this.centerDesc = centerDesc;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromImId() {
		return fromImId;
	}

	public void setFromImId(String fromImId) {
		this.fromImId = fromImId;
	}

	public String getFromNickname() {
		return fromNickname;
	}

	public void setFromNickname(String fromNickname) {
		this.fromNickname = fromNickname;
	}

}
