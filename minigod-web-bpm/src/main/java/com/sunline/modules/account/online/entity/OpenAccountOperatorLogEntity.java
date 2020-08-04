package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户开户业务操作员日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-01 09:34:03
 */
public class OpenAccountOperatorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//预约流水号
	private String applicationId;
	//节点名称
	private String currentNode;
	//任务ID
	private Integer taskId;
	//操作类型[0-未知 1-编辑资料 2-补充资料 3-上传aml文件 4-删除aml文件]
	private Integer operateType;
	//编辑字段(多个字段用|间隔)
	private String editFields;
	//操作人
	private String createUser;
	//更新人
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
	 * 设置：操作类型[0-未知 1-编辑资料 2-补充资料]
	 */
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	/**
	 * 获取：操作类型[0-未知 1-编辑资料 2-补充资料]
	 */
	public Integer getOperateType() {
		return operateType;
	}
	/**
	 * 设置：编辑字段(多个字段用|间隔)
	 */
	public void setEditFields(String editFields) {
		this.editFields = editFields;
	}
	/**
	 * 获取：编辑字段(多个字段用|间隔)
	 */
	public String getEditFields() {
		return editFields;
	}
	/**
	 * 设置：操作人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：操作人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
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
