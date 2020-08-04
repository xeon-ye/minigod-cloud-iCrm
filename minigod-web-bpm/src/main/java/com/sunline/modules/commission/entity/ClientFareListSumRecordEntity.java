package com.sunline.modules.commission.entity;

import java.io.Serializable;


/**
 * 客户费率设置汇总表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
public class ClientFareListSumRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private String id;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//证券市场[K-港交所 P-美国市场]
	private String exchangeType;
	//费用类型[0-服务费 1-交易费]
	private String fareDict;
	//收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	private String feeType;
	//付费数值
	private String feeCount;
	//固定费用
	private String feeCountFix;
	//最低费用
	private String minFare;
	//最高费用
	private String maxFare;
	//开始日期
	private String beginDate;
	//结束日期
	private String endDate;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;

	/**
	 * 设置：自增ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public String getId() {
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
	 * 设置：证券市场[K-港交所 P-美国市场]
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	/**
	 * 获取：证券市场[K-港交所 P-美国市场]
	 */
	public String getExchangeType() {
		return exchangeType;
	}
	/**
	 * 设置：费用类型[0-服务费 1-交易费]
	 */
	public void setFareDict(String fareDict) {
		this.fareDict = fareDict;
	}
	/**
	 * 获取：费用类型[0-服务费 1-交易费]
	 */
	public String getFareDict() {
		return fareDict;
	}
	/**
	 * 设置：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * 获取：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * 设置：付费数值
	 */
	public void setFeeCount(String feeCount) {
		this.feeCount = feeCount;
	}
	/**
	 * 获取：付费数值
	 */
	public String getFeeCount() {
		return feeCount;
	}
	/**
	 * 设置：固定费用
	 */
	public void setFeeCountFix(String feeCountFix) {
		this.feeCountFix = feeCountFix;
	}
	/**
	 * 获取：固定费用
	 */
	public String getFeeCountFix() {
		return feeCountFix;
	}
	/**
	 * 设置：最低费用
	 */
	public void setMinFare(String minFare) {
		this.minFare = minFare;
	}
	/**
	 * 获取：最低费用
	 */
	public String getMinFare() {
		return minFare;
	}
	/**
	 * 设置：最高费用
	 */
	public void setMaxFare(String maxFare) {
		this.maxFare = maxFare;
	}
	/**
	 * 获取：最高费用
	 */
	public String getMaxFare() {
		return maxFare;
	}
	/**
	 * 设置：开始日期
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：开始日期
	 */
	public String getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}
}
