package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * <code>StkSumVO<code>[个股概要信息查询类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */
public class StkPirceReminderVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;

	private String assetId;
	private Double priceUpTo; // 股价涨到
	private Double priceDownTo; // 股价跌到
	private Double changePctUpTo; // 日涨幅到
	private Double changePctDownTo; // 日跌幅到
	private Integer reminderRate; // 提醒频率 1：仅提醒一次  2：每日一次	 3：持续提醒
	private Integer reminderType; // 提醒方式 1：程序提醒	   2：短信提醒
	private String updateTime; // 更新时间
	private Boolean remindered; // 当日是否已提醒

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Double getPriceUpTo() {
		return priceUpTo;
	}

	public void setPriceUpTo(Double priceUpTo) {
		this.priceUpTo = priceUpTo;
	}

	public Double getPriceDownTo() {
		return priceDownTo;
	}

	public void setPriceDownTo(Double priceDownTo) {
		this.priceDownTo = priceDownTo;
	}

	public Double getChangePctUpTo() {
		return changePctUpTo;
	}

	public void setChangePctUpTo(Double changePctUpTo) {
		this.changePctUpTo = changePctUpTo;
	}

	public Double getChangePctDownTo() {
		return changePctDownTo;
	}

	public void setChangePctDownTo(Double changePctDownTo) {
		this.changePctDownTo = changePctDownTo;
	}

	public Integer getReminderRate() {
		return reminderRate;
	}

	public void setReminderRate(Integer reminderRate) {
		this.reminderRate = reminderRate;
	}

	public Integer getReminderType() {
		return reminderType;
	}

	public void setReminderType(Integer reminderType) {
		this.reminderType = reminderType;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getRemindered() {
		return remindered;
	}

	public void setRemindered(Boolean remindered) {
		this.remindered = remindered;
	}
}
