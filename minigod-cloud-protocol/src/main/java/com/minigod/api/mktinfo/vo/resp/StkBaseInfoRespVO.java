/**
 * @Title: StkBaseInfoRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-19 下午10:23:36
 * @version v1.0
 */

public class StkBaseInfoRespVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String assetId;// 股票资产ID
	private String profile;// 公司简介
	private Double revenueRate;// 营业收入同比增长
	private Double profitRate;// 净利润同比增长
	private String forecastTitle;// 业绩预告标题
	private String period;// 周期

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Double getRevenueRate() {
		return revenueRate;
	}

	public void setRevenueRate(Double revenueRate) {
		this.revenueRate = revenueRate;
	}

	public Double getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(Double profitRate) {
		this.profitRate = profitRate;
	}

	public String getForecastTitle() {
		return forecastTitle;
	}

	public void setForecastTitle(String forecastTitle) {
		this.forecastTitle = forecastTitle;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
