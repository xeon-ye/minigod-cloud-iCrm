package com.sunline.modules.commission.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户免佣套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:40:27
 */
public class ClientFreeCommSetEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//审核人
	private String auditUser;
	//审核状态[0-未审核 1-审核通过 2-审核不通过]
	private Integer auditStatus;
	//审核时间
	private Date auditTime;
	//同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	private Integer syncStatus;
	//同步时间
	private Date syncTime;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

    /**
     * 免佣类型[0-开户免佣 1-推荐股友免佣 2-入金免佣]
     */
    private Integer freeCommType;

    /**
     * 证券市场[K-港交所 P-美国市场]
     */
    private String exchangeType;

	/**
	 * 设置：自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：交易帐号
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易帐号
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * 设置：资金帐号
	 */
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**
	 * 获取：资金帐号
	 */
	public String getFundAccount() {
		return fundAccount;
	}
	/**
	 * 设置：开始日期
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：开始日期
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：审核人
	 */
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	/**
	 * 获取：审核人
	 */
	public String getAuditUser() {
		return auditUser;
	}
	/**
	 * 设置：审核状态[0-未审核 1-审核通过 2-审核不通过]
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态[0-未审核 1-审核通过 2-审核不通过]
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * 设置：同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	 */
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	/**
	 * 获取：同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	 */
	public Integer getSyncStatus() {
		return syncStatus;
	}
	/**
	 * 设置：同步时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	/**
	 * 获取：同步时间
	 */
	public Date getSyncTime() {
		return syncTime;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public Integer getFreeCommType() {
        return freeCommType;
    }

    public void setFreeCommType(Integer freeCommType) {
        this.freeCommType = freeCommType;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
}
