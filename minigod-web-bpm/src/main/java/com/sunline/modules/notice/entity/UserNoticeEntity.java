package com.sunline.modules.notice.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
public class UserNoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String userId;
	//
	private String noticeCaseId;
	//
	private String createUser;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setNoticeCaseId(String noticeCaseId) {
		this.noticeCaseId = noticeCaseId;
	}
	/**
	 * 获取：
	 */
	public String getNoticeCaseId() {
		return noticeCaseId;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
