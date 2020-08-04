package com.sunline.modules.commission.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道客户佣金套餐还原历史表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-28 15:51:06
 */
public class ChannelClientFareSetupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//渠道号
	private Integer channelId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//套餐编号
	private String fareKind;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//同步状态[0-未同步 1-正在同步 2-同步成功 3-同步失败]
	private Integer syncStatus;
	//同步时间
	private Date syncTime;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

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
	 * 设置：渠道号
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：渠道号
	 */
	public Integer getChannelId() {
		return channelId;
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
	 * 设置：套餐编号
	 */
	public void setFareKind(String fareKind) {
		this.fareKind = fareKind;
	}
	/**
	 * 获取：套餐编号
	 */
	public String getFareKind() {
		return fareKind;
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
	 * 设置：同步状态[0-未同步 1-正在同步 2-同步成功 3-同步失败]
	 */
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	/**
	 * 获取：同步状态[0-未同步 1-正在同步 2-同步成功 3-同步失败]
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
}
