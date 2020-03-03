package com.minigod.api.grm.v2.push;

import java.util.Date;

/**
 * 成交推送消息
 * @author gc
 *
 */
public class GrmTradeNotificationMessage {
	
	// serial_no
	// deal_status
	// entrust_type
	// mobile_tel
	// e_mail
	// replay_type
	// lang_type
	// business_date
	// business_no
	// real_type
	// real_status
	// 
	// sum_business_balance
	// sum_business_amount
	// avg_business_price
	// original_price
	// original_amount
	// left_amount
	// 
	// 
	// remark
	// replay_op
	// f20_exectranstype
	// f39_ordstatus
	// f150_exectype
	// serial_syn
	// clear_date
	// 
	private String assetId; // 资产ID
	
	/**
	 * 成交类别
	 * '0'	买卖
	 * '1'	查询
	 * '2'	撤单
	 */
	private String realType;
	
	// 发生日期、时间
	private Date time;
	// 客户标识
	/**
	 * 资产账号
	 */
	private String fundAccount;
	/**
	 * 客户编号
	 */
	private String clientId;	
	// 订单标识
	/**
	 * 委托编号
	 */
	private int entrustNo;
	// 买卖标识
	/**
	 * char 买卖方向
	 */
	private String entrustBs;
	// 委托数量、价格
	
	// 成交数量、价格
	/**
	 * double 成交数量
	 */
	private double businessAmount;
	/**
	 * double 成交价格
	 */
	private double businessPrice;
	/**
	 * double 成交金额
	 */
	private double businessBalance;
	/**
	 * int 成交时间
	 */
	private int businessTime;
	// 订单状态
	
	/**
	 * int 分支代码
	 */
	private int branchNo;

	
	/**
	 * char[8] 席位编号
	 */
	private String seatNo;

	/**
	 * double 委托数量
	 */
	private double entrustAmount;
	/**
	 * double 委托价格
	 */
	private double entrustPrice;
	/**
	 * char 委托状态
	 */
	private String entrustStatus;


	/**
	 * int 申报时间
	 */
	private int reportTime;
	/**
	 * char 币种类别
	 */
	private String moneyType;
	/**
	 * int 委托时间
	 */
	private int entrustTime;
	//
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFundAccount() {
		return fundAccount;
	}
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getEntrustNo() {
		return entrustNo;
	}
	public void setEntrustNo(int entrustNo) {
		this.entrustNo = entrustNo;
	}
	public String getEntrustBs() {
		return entrustBs;
	}
	public void setEntrustBs(String entrustBs) {
		this.entrustBs = entrustBs;
	}
	public double getBusinessAmount() {
		return businessAmount;
	}
	public void setBusinessAmount(double businessAmount) {
		this.businessAmount = businessAmount;
	}
	public double getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}
	public double getBusinessBalance() {
		return businessBalance;
	}
	public void setBusinessBalance(double businessBalance) {
		this.businessBalance = businessBalance;
	}
	public int getBusinessTime() {
		return businessTime;
	}
	public void setBusinessTime(int businessTime) {
		this.businessTime = businessTime;
	}
	public int getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public double getEntrustAmount() {
		return entrustAmount;
	}
	public void setEntrustAmount(double entrustAmount) {
		this.entrustAmount = entrustAmount;
	}
	public double getEntrustPrice() {
		return entrustPrice;
	}
	public void setEntrustPrice(double entrustPrice) {
		this.entrustPrice = entrustPrice;
	}
	public String getEntrustStatus() {
		return entrustStatus;
	}
	public void setEntrustStatus(String entrustStatus) {
		this.entrustStatus = entrustStatus;
	}
	public int getReportTime() {
		return reportTime;
	}
	public void setReportTime(int reportTime) {
		this.reportTime = reportTime;
	}
	public String getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public int getEntrustTime() {
		return entrustTime;
	}
	public void setEntrustTime(int entrustTime) {
		this.entrustTime = entrustTime;
	}
	public String getRealType() {
		return realType;
	}
	public void setRealType(String realType) {
		this.realType = realType;
	}
	
}
