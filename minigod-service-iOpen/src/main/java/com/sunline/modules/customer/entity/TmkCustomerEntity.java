package com.sunline.modules.customer.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 电销客户管理信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-23 10:17:43
 */
public class TmkCustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//分配日期
	private String distributionDate;
	//手机号码
	private String phoneNumber;
	// 是否开通微信[0-否 1-是]
	private String isOpenWechat;
	//客户性别
	private String sex;
	//港美股经验
	private String stockExperience;
	//资产级别
	private String assetLevel;
	//备注
	private String remark;
	//触达情况[1-成功接听 2-成功接听 3-无人接听 4-关机 5-无法接通 6-号码错误]
	private Integer contactStatus;
	//添加微信[0-否 1-是]
	private Integer addWechat;
	//开户情况[0-否 1-是]
	private Integer openAccountStatus;
	//入金情况[0-否 1-是]
	private Integer depositStatus;
	// 香港银行卡[0-否 1-是]
	private Integer isBankCard;
	//沟通内容记录
	private String contentDescription;
	// 操作人
	private String operator;
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
	 * 设置：分配日期
	 */
	public void setDistributionDate(String distributionDate) {
		this.distributionDate = distributionDate;
	}
	/**
	 * 获取：分配日期
	 */
	public String getDistributionDate() {
		return distributionDate;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：客户性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：客户性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：港美股经验
	 */
	public void setStockExperience(String stockExperience) {
		this.stockExperience = stockExperience;
	}
	/**
	 * 获取：港美股经验
	 */
	public String getStockExperience() {
		return stockExperience;
	}
	/**
	 * 设置：资产级别
	 */
	public void setAssetLevel(String assetLevel) {
		this.assetLevel = assetLevel;
	}
	/**
	 * 获取：资产级别
	 */
	public String getAssetLevel() {
		return assetLevel;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：触达情况[1-成功接听 2-成功接听 3-无人接听 4-关机 5-无法接通 6-号码错误]
	 */
	public void setContactStatus(Integer contactStatus) {
		this.contactStatus = contactStatus;
	}
	/**
	 * 获取：触达情况[1-成功接听 2-成功接听 3-无人接听 4-关机 5-无法接通 6-号码错误]
	 */
	public Integer getContactStatus() {
		return contactStatus;
	}
	/**
	 * 设置：添加微信[0-否 1-是]
	 */
	public void setAddWechat(Integer addWechat) {
		this.addWechat = addWechat;
	}
	/**
	 * 获取：添加微信[0-否 1-是]
	 */
	public Integer getAddWechat() {
		return addWechat;
	}
	/**
	 * 设置：开户情况[0-否 1-是]
	 */
	public void setOpenAccountStatus(Integer openAccountStatus) {
		this.openAccountStatus = openAccountStatus;
	}
	/**
	 * 获取：开户情况[0-否 1-是]
	 */
	public Integer getOpenAccountStatus() {
		return openAccountStatus;
	}
	/**
	 * 设置：入金情况[0-否 1-是]
	 */
	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}
	/**
	 * 获取：入金情况[0-否 1-是]
	 */
	public Integer getDepositStatus() {
		return depositStatus;
	}
	/**
	 * 设置：沟通内容记录
	 */
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}
	/**
	 * 获取：沟通内容记录
	 */
	public String getContentDescription() {
		return contentDescription;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getIsOpenWechat() {
        return isOpenWechat;
    }

    public void setIsOpenWechat(String isOpenWechat) {
        this.isOpenWechat = isOpenWechat;
    }

    public Integer getIsBankCard() {
        return isBankCard;
    }

    public void setIsBankCard(Integer isBankCard) {
        this.isBankCard = isBankCard;
    }
}
