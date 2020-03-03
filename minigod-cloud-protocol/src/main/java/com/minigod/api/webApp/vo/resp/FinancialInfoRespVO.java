/**
 * @Title: FinancialInfoRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 理财信息返回类
 * 
 * @author minigod
 * @date 2016-1-22 下午5:57:36
 * @version v1.0
 */

public class FinancialInfoRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String interestRate; // 当前用户当前日期年化收益率（值*100得百分比）

	private String increaseInterest; // 加息部分=（当前用户当前日期年化收益率 - 公共初始利率）*100

	private String remainQuota; // 剩余额度

	private Integer totalInvestNum; // 总投资人数

	private String totalInvestAmount; // 累计投资金额

	private String compositeRate; // 复合年化收益率

	private String composite; // 今日每万元收益=10000*当日年化收益率/365

	private List<String> lstOrderDesc; // 最近购买的10条记录

	private String demoBaseRate; // minigod證券國際基准年化收益率

	private String demoProfit; // minigod證券國際30天收益

	private String demoMaxRate; // minigod證券國際最高年化收益率
	
	private String refreshNotice; // 是否接收额度更新通知
	
	private String quotaCanBuy; // 额度是否可购买(剩余额度大于等于最小购买金额)
	
	private String isHasCoupon; // 用户当前是否有未使用的加息券(Y:有; N:无)
	
	private Integer userType; // 用户类型，0：游客；1：正式用户；2：投顾

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getIncreaseInterest() {
		return increaseInterest;
	}

	public void setIncreaseInterest(String increaseInterest) {
		this.increaseInterest = increaseInterest;
	}

	public String getRemainQuota() {
		return remainQuota;
	}

	public void setRemainQuota(String remainQuota) {
		this.remainQuota = remainQuota;
	}

	public Integer getTotalInvestNum() {
		return totalInvestNum;
	}

	public void setTotalInvestNum(Integer totalInvestNum) {
		this.totalInvestNum = totalInvestNum;
	}

	public String getTotalInvestAmount() {
		return totalInvestAmount;
	}

	public void setTotalInvestAmount(String totalInvestAmount) {
		this.totalInvestAmount = totalInvestAmount;
	}

	public String getCompositeRate() {
		return compositeRate;
	}

	public void setCompositeRate(String compositeRate) {
		this.compositeRate = compositeRate;
	}

	public String getComposite() {
		return composite;
	}

	public void setComposite(String composite) {
		this.composite = composite;
	}

	public List<String> getLstOrderDesc() {
		return lstOrderDesc;
	}

	public void setLstOrderDesc(List<String> lstOrderDesc) {
		this.lstOrderDesc = lstOrderDesc;
	}

	public String getDemoBaseRate() {
		return demoBaseRate;
	}

	public void setDemoBaseRate(String demoBaseRate) {
		this.demoBaseRate = demoBaseRate;
	}

	public String getDemoProfit() {
		return demoProfit;
	}

	public void setDemoProfit(String demoProfit) {
		this.demoProfit = demoProfit;
	}

	public String getDemoMaxRate() {
		return demoMaxRate;
	}

	public void setDemoMaxRate(String demoMaxRate) {
		this.demoMaxRate = demoMaxRate;
	}

	public String getRefreshNotice() {
		return refreshNotice;
	}

	public void setRefreshNotice(String refreshNotice) {
		this.refreshNotice = refreshNotice;
	}

	public String getQuotaCanBuy() {
		return quotaCanBuy;
	}

	public void setQuotaCanBuy(String quotaCanBuy) {
		this.quotaCanBuy = quotaCanBuy;
	}

	public String getIsHasCoupon() {
		return isHasCoupon;
	}

	public void setIsHasCoupon(String isHasCoupon) {
		this.isHasCoupon = isHasCoupon;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}
