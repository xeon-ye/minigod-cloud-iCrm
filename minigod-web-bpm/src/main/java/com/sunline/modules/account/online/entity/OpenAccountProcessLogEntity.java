package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户开户业务流程日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 20:55:10
 */
public class OpenAccountProcessLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//预约流水号
	private String applicationId;
	//节点名称
	private String currentNode;
	//任务ID
	private Integer taskId;
	//是否编辑资料[0-否 1-是]
	private Integer isEdit;
	//是否补充资料[0-否 1-是]
	private Integer isAdditional;
	//是否流程退回[0-否 1-是]
	private Integer isBackWorkflow;
	//是否退回APP[0-否 1-是]
	private Integer isBackApp;
	//是否拒绝[0-否 1-是]
	private Integer isReject;
	//是否拒绝并加入黑名单[0-否 1-是]
	private Integer isRejectBlacklist;
	//退回理由类型JSON[0-无 1-]
	private String backReasonType;
	//编辑资料人ID
	private String isEditUser;
	//补充资料人ID
	private String isAdditionalUser;
	//流程发起人ID
	private String createUser;
	//流程更新人ID
	private String updateUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：预约流水号
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * 获取：预约流水号
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * 设置：节点名称
	 */
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
	/**
	 * 获取：节点名称
	 */
	public String getCurrentNode() {
		return currentNode;
	}
	/**
	 * 设置：任务ID
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取：任务ID
	 */
	public Integer getTaskId() {
		return taskId;
	}
	/**
	 * 设置：是否编辑资料[0-否 1-是]
	 */
	public void setIsEdit(Integer isEdit) {
		this.isEdit = isEdit;
	}
	/**
	 * 获取：是否编辑资料[0-否 1-是]
	 */
	public Integer getIsEdit() {
		return isEdit;
	}
	/**
	 * 设置：是否补充资料[0-否 1-是]
	 */
	public void setIsAdditional(Integer isAdditional) {
		this.isAdditional = isAdditional;
	}
	/**
	 * 获取：是否补充资料[0-否 1-是]
	 */
	public Integer getIsAdditional() {
		return isAdditional;
	}
	/**
	 * 设置：是否流程退回[0-否 1-是]
	 */
	public void setIsBackWorkflow(Integer isBackWorkflow) {
		this.isBackWorkflow = isBackWorkflow;
	}
	/**
	 * 获取：是否流程退回[0-否 1-是]
	 */
	public Integer getIsBackWorkflow() {
		return isBackWorkflow;
	}
	/**
	 * 设置：是否退回APP[0-否 1-是]
	 */
	public void setIsBackApp(Integer isBackApp) {
		this.isBackApp = isBackApp;
	}
	/**
	 * 获取：是否退回APP[0-否 1-是]
	 */
	public Integer getIsBackApp() {
		return isBackApp;
	}
	/**
	 * 设置：是否拒绝[0-否 1-是]
	 */
	public void setIsReject(Integer isReject) {
		this.isReject = isReject;
	}
	/**
	 * 获取：是否拒绝[0-否 1-是]
	 */
	public Integer getIsReject() {
		return isReject;
	}
	/**
	 * 设置：是否拒绝并加入黑名单[0-否 1-是]
	 */
	public void setIsRejectBlacklist(Integer isRejectBlacklist) {
		this.isRejectBlacklist = isRejectBlacklist;
	}
	/**
	 * 获取：是否拒绝并加入黑名单[0-否 1-是]
	 */
	public Integer getIsRejectBlacklist() {
		return isRejectBlacklist;
	}
	/**
	 * 设置：退回理由类型JSON[0-无 1-]
	 */
	public void setBackReasonType(String backReasonType) {
		this.backReasonType = backReasonType;
	}
	/**
	 * 获取：退回理由类型JSON[0-无 1-]
	 */
	public String getBackReasonType() {
		return backReasonType;
	}
	/**
	 * 设置：编辑资料人ID
	 */
	public void setIsEditUser(String isEditUser) {
		this.isEditUser = isEditUser;
	}
	/**
	 * 获取：编辑资料人ID
	 */
	public String getIsEditUser() {
		return isEditUser;
	}
	/**
	 * 设置：补充资料人ID
	 */
	public void setIsAdditionalUser(String isAdditionalUser) {
		this.isAdditionalUser = isAdditionalUser;
	}
	/**
	 * 获取：补充资料人ID
	 */
	public String getIsAdditionalUser() {
		return isAdditionalUser;
	}
	/**
	 * 设置：流程发起人ID
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：流程发起人ID
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：流程更新人ID
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：流程更新人ID
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
