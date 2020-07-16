package com.sunline.modules.commission.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 客户免佣套餐信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:55:32
 */
public class ClientFreeCommInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//费用类型[0-服务费 1-交易费]
	private String fareDict;
	//收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	private String feeType;
	//付费数值
	private BigDecimal feeCount;
	//费用类别
	private String fareType;
	//证券市场[K-港交所 P-美国市场]
	private String exchangeType;
	//股票类型
	private String stockType;
	//股票代码
	private String stockCode;
	//买卖方向
	private String entrustBs;
	//委托方式
	private String entrustWay;
	//币种代码
	private String moneyType;
	//最低费用
	private BigDecimal minFare;
	//最高费用
	private BigDecimal maxFare;
	//截位方式
	private String precisions;
	//精度
	private String precisionFlag;
	//固定费用
	private BigDecimal feeCountFix;
	//费用描述
	private String fareStr;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	// 状态[0-无效 1-有效]
	private Integer freeCommStatus;

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
	public void setFeeCount(BigDecimal feeCount) {
		this.feeCount = feeCount;
	}
	/**
	 * 获取：付费数值
	 */
	public BigDecimal getFeeCount() {
		return feeCount;
	}
	/**
	 * 设置：费用类别
	 */
	public void setFareType(String fareType) {
		this.fareType = fareType;
	}
	/**
	 * 获取：费用类别
	 */
	public String getFareType() {
		return fareType;
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
	 * 设置：股票类型
	 */
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	/**
	 * 获取：股票类型
	 */
	public String getStockType() {
		return stockType;
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
	 * 设置：买卖方向
	 */
	public void setEntrustBs(String entrustBs) {
		this.entrustBs = entrustBs;
	}
	/**
	 * 获取：买卖方向
	 */
	public String getEntrustBs() {
		return entrustBs;
	}
	/**
	 * 设置：委托方式
	 */
	public void setEntrustWay(String entrustWay) {
		this.entrustWay = entrustWay;
	}
	/**
	 * 获取：委托方式
	 */
	public String getEntrustWay() {
		return entrustWay;
	}
	/**
	 * 设置：币种代码
	 */
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	/**
	 * 获取：币种代码
	 */
	public String getMoneyType() {
		return moneyType;
	}
	/**
	 * 设置：最低费用
	 */
	public void setMinFare(BigDecimal minFare) {
		this.minFare = minFare;
	}
	/**
	 * 获取：最低费用
	 */
	public BigDecimal getMinFare() {
		return minFare;
	}
	/**
	 * 设置：最高费用
	 */
	public void setMaxFare(BigDecimal maxFare) {
		this.maxFare = maxFare;
	}
	/**
	 * 获取：最高费用
	 */
	public BigDecimal getMaxFare() {
		return maxFare;
	}
	/**
	 * 设置：截位方式
	 */
	public void setPrecisions(String precisions) {
		this.precisions = precisions;
	}
	/**
	 * 获取：截位方式
	 */
	public String getPrecisions() {
		return precisions;
	}
	/**
	 * 设置：精度
	 */
	public void setPrecisionFlag(String precisionFlag) {
		this.precisionFlag = precisionFlag;
	}
	/**
	 * 获取：精度
	 */
	public String getPrecisionFlag() {
		return precisionFlag;
	}
	/**
	 * 设置：固定费用
	 */
	public void setFeeCountFix(BigDecimal feeCountFix) {
		this.feeCountFix = feeCountFix;
	}
	/**
	 * 获取：固定费用
	 */
	public BigDecimal getFeeCountFix() {
		return feeCountFix;
	}
	/**
	 * 设置：费用描述
	 */
	public void setFareStr(String fareStr) {
		this.fareStr = fareStr;
	}
	/**
	 * 获取：费用描述
	 */
	public String getFareStr() {
		return fareStr;
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

    public Integer getFreeCommStatus() {
        return freeCommStatus;
    }

    public void setFreeCommStatus(Integer freeCommStatus) {
        this.freeCommStatus = freeCommStatus;
    }
}
