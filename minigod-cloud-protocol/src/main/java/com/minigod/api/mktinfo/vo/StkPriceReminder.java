/**
 * @Title: TimesharingHis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * <code>StkPriceReminder</code>
 * 
 * @author HUHU
 * @date 2016-10-24
 * @version v1.0
 */
public class StkPriceReminder implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeMap<Integer,PriceReminder> data;
	public TreeMap<Integer, PriceReminder> getData() {
		return data;
	}
	public void setData(TreeMap<Integer, PriceReminder> data) {
		this.data = data;
	}

	public static class PriceReminder implements Serializable {
		private static final long serialVersionUID = 1L;

		private Double priceUpTo; // 股价涨到
		private Double priceDownTo; // 股价跌到
		private Double changePctUpTo; // 日涨幅到
		private Double changePctDownTo; // 日跌幅到
		private Integer reminderRate; // 提醒频率 1：仅提醒一次  2：每日一次	 3：持续提醒
		private Integer reminderType; // 提醒方式 1：程序提醒	   2：短信提醒
		private String updateTime; // 更新时间
		private boolean remindered; //当天是否已经提醒过 用于每日一次
		
		//用于持续提醒的标志位
		private int priceUpToCount; //默认为1，提醒后清零，低于设置的价格后再将其置为1
		private int priceDownToCount; //默认为1，提醒后清零，高于设置的价格后再将其置为1
		private int changePctUpToCount;//默认为1，提醒后清零，低于设置的涨幅后再将其置为1
		private int changePctDownToToCount;//默认为1，提醒后清零，高于设置的跌幅后再将其置为1
		private int reasonType;//触发发送提醒消息的原因 1.上涨超标.2.下跌超标.3.涨幅超标.4.跌幅超标
		
		

		public int getReasonType() {
			return reasonType;
		}

		public void setReasonType(int reasonType) {
			this.reasonType = reasonType;
		}

		public int getPriceUpToCount() {
			return priceUpToCount;
		}

		public void setPriceUpToCount(int priceUpToCount) {
			this.priceUpToCount = priceUpToCount;
		}

		public int getPriceDownToCount() {
			return priceDownToCount;
		}

		public void setPriceDownToCount(int priceDownToCount) {
			this.priceDownToCount = priceDownToCount;
		}

		public int getChangePctUpToCount() {
			return changePctUpToCount;
		}

		public void setChangePctUpToCount(int changePctUpToCount) {
			this.changePctUpToCount = changePctUpToCount;
		}

		public int getChangePctDownToToCount() {
			return changePctDownToToCount;
		}

		public void setChangePctDownToToCount(int changePctDownToToCount) {
			this.changePctDownToToCount = changePctDownToToCount;
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

		public boolean getRemindered() {
			return remindered;
		}

		public void setRemindered(boolean remindered) {
			this.remindered = remindered;
		}
	}

	public static enum EReminderRate {
		ONCE(1),ONCE_ERVERYDAY(2),CONTINUE(3);
		private final int no;
		private EReminderRate(int no){
			this.no = no;
		}
		public int getNo(){
			return this.no;
		}
	}

	public static enum EReminderType {
		APP(1),MSG(2);
		private final int no;
		private EReminderType(int no){
			this.no = no;
		}
		public int getNo(){
			return this.no;
		}
	}


}
