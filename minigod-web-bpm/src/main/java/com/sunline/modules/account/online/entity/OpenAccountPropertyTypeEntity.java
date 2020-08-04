package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 财产种类表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountPropertyTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//预约流水号
	private String applicationId;
	//财产种类
	private Integer propertyType;
	//财产金额
	private String propertyAmount;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
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
	 * 设置：财产种类
	 */
	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}
	/**
	 * 获取：财产种类
	 */
	public Integer getPropertyType() {
		return propertyType;
	}
	/**
	 * 设置：财产金额
	 */
	public void setPropertyAmount(String propertyAmount) {
		this.propertyAmount = propertyAmount;
	}
	/**
	 * 获取：财产金额
	 */
	public String getPropertyAmount() {
		return propertyAmount;
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
