package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 黑名单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 12:19:54
 */
public class OpenAccountBlacklistEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//预约流水号
	private String applicationId;
	//客户中文名
	private String clientName;
	//证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
	private Integer idKind;
	//证件号码
	private String idNo;
	//手机号
	private String phoneNumber;
	//电子邮箱
	private String email;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//操作用户
	private String createUser;

	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
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
	 * 设置：客户中文名
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：客户中文名
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
	 */
	public void setIdKind(Integer idKind) {
		this.idKind = idKind;
	}
	/**
	 * 获取：证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
	 */
	public Integer getIdKind() {
		return idKind;
	}
	/**
	 * 设置：证件号码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
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
