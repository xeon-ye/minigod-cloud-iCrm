package com.sunline.modules.notice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
public class NoticeCaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String noticeCaseId;
	//
	private String noticeCaseName;
	//
	private Integer noticeCaseCode;
	//
	private String createUser;
	//
	private Date createTime;
	//
	private String updateUser;
	//
	private Date updateTime;
    //
    private List<String> userIds;
    //
    private String noticeContext;

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
	public void setNoticeCaseName(String noticeCaseName) {
		this.noticeCaseName = noticeCaseName;
	}
	/**
	 * 获取：
	 */
	public String getNoticeCaseName() {
		return noticeCaseName;
	}
	/**
	 * 设置：
	 */
	public void setNoticeCaseCode(Integer noticeCaseCode) {
		this.noticeCaseCode = noticeCaseCode;
	}
	/**
	 * 获取：
	 */
	public Integer getNoticeCaseCode() {
		return noticeCaseCode;
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
	/**
	 * 设置：
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext;
    }
}
