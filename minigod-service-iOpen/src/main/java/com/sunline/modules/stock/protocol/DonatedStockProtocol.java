package com.sunline.modules.stock.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 赠股申请信息
 * 
 * @author lcs
 * @email
 * @date 2018-12-10 15:38:58
 */
public class DonatedStockProtocol  extends BaseParameter {
	private static final long serialVersionUID = 1L;
	
	//小神号
	private Integer userId;
	//渠道号
	private String channelId;
	//交易帐号/客户帐号
	private String clientId;
	//客户名称
	private String clientName;
	//证券手机号
	private String phoneNumber;
	//股票代码
	private String stockCode;
	//股票名称
	private String stockName;
	//股票数量
	private Integer stockQuantity;
	//总成本HKD
	private BigDecimal totalCost;
	//活动ID
	private String activityId;
	//活动名称
	private String activityName;
	//方案ID
	private String programmeId;
	//领取时间
	private String receiveTime;
	//流水号
    private String applicationId;
	//奖励类型 1开户 2入金 3转仓 5积分兑换
	private Integer activType;


	/**
	 * 设置：小神号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：小神号
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：渠道号
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：渠道号
	 */
	public String getChannelId() {
		return channelId;
	}
	/**
	 * 设置：交易帐号/客户帐号
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易帐号/客户帐号
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * 设置：客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：证券手机号
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：证券手机号
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：股票代码
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * 获取：股票代码
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * 设置：股票名称
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * 获取：股票名称
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * 设置：股票数量
	 */
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	/**
	 * 获取：股票数量
	 */
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	/**
	 * 设置：总成本HKD
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * 获取：总成本HKD
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	/**
	 * 设置：活动ID
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：活动ID
	 */
	public String getActivityId() {
		return activityId;
	}
	/**
	 * 设置：活动名称
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	/**
	 * 获取：活动名称
	 */
	public String getActivityName() {
		return activityName;
	}
	/**
	 * 设置：方案ID
	 */
	public void setProgrammeId(String programmeId) {
		this.programmeId = programmeId;
	}
	/**
	 * 获取：方案ID
	 */
	public String getProgrammeId() {
		return programmeId;
	}
	/**
	 * 设置：领取时间
	 */
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	/**
	 * 获取：领取时间
	 */
	public String getReceiveTime() {
		return receiveTime;
	}

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

	public Integer getActivType() {
		return activType;
	}

	public void setActivType(Integer activType) {
		this.activType = activType;
	}
}
