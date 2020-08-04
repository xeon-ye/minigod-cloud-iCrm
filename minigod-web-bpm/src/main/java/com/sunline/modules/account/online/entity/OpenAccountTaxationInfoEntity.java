package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 税务信息表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountTaxationInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//预约流水号
	private String applicationId;
	//司法管辖区
	private String taxCountry;
	//税务编号
	private String taxNumber;
	//是否有税务编号[0=否 1=是]
	private Integer hasTaxNumber;
	//理由类型
	private String reasonType;
	//理由描述
	private String reasonDesc;
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
	 * 设置：司法管辖区
	 */
	public void setTaxCountry(String taxCountry) {
		this.taxCountry = taxCountry;
	}
	/**
	 * 获取：司法管辖区
	 */
	public String getTaxCountry() {
		return taxCountry;
	}
	/**
	 * 设置：税务编号
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	/**
	 * 获取：税务编号
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	/**
	 * 设置：是否有税务编号[0=否 1=是]
	 */
	public void setHasTaxNumber(Integer hasTaxNumber) {
		this.hasTaxNumber = hasTaxNumber;
	}
	/**
	 * 获取：是否有税务编号[0=否 1=是]
	 */
	public Integer getHasTaxNumber() {
		return hasTaxNumber;
	}
	/**
	 * 设置：理由类型
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}
	/**
	 * 获取：理由类型
	 */
	public String getReasonType() {
		return reasonType;
	}
    /**
     * 获取：理由描述
     */
    public String getReasonDesc() {
        return reasonDesc;
    }
    /**
     * 设置：理由描述
     */
    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
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
