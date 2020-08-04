package com.sunline.modules.common.entity;

import java.io.Serializable;



/**
 * 
 * 
 * @author lcs
 * @email 
 * @date 2018-05-25 13:50:28
 */
public class StkTrdCaleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//交易日历ID
	private Integer calendarId;
	//自然日期
	private String normalDate;
	//地区
	private String regionCode;
	//当天是否交易日
	private Boolean isTradeDay;
	//上一个交易日
	private String lastTrd;
	//下一个交易日
	private String nextTrd;
	//是否本周最后一个交易日
	private Integer isWeekEnd;
	//是否本月最后一个交易日
	private Integer isMonthEnd;
	//是否本年最后一个交易日
	private Integer isYearEnd;
	//上周最后一个交易日
	private String lastWeekTrd;
	//上月最后一个交易日
	private String lastMonthTrd;
	//上年最后一个交易日
	private String lastYearTrd;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;
	//外部系统时间
	private String extTime;
	//备注
	private String remark;

	/**
	 * 设置：交易日历ID
	 */
	public void setCalendarId(Integer calendarId) {
		this.calendarId = calendarId;
	}
	/**
	 * 获取：交易日历ID
	 */
	public Integer getCalendarId() {
		return calendarId;
	}
	/**
	 * 设置：自然日期
	 */
	public void setNormalDate(String normalDate) {
		this.normalDate = normalDate;
	}
	/**
	 * 获取：自然日期
	 */
	public String getNormalDate() {
		return normalDate;
	}
	/**
	 * 设置：地区
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	/**
	 * 获取：地区
	 */
	public String getRegionCode() {
		return regionCode;
	}
	/**
	 * 设置：当天是否交易日
	 */
	public void setIsTradeDay(Boolean isTradeDay) {
		this.isTradeDay = isTradeDay;
	}
	/**
	 * 获取：当天是否交易日
	 */
	public Boolean getIsTradeDay() {
		return isTradeDay;
	}
	/**
	 * 设置：上一个交易日
	 */
	public void setLastTrd(String lastTrd) {
		this.lastTrd = lastTrd;
	}
	/**
	 * 获取：上一个交易日
	 */
	public String getLastTrd() {
		return lastTrd;
	}
	/**
	 * 设置：下一个交易日
	 */
	public void setNextTrd(String nextTrd) {
		this.nextTrd = nextTrd;
	}
	/**
	 * 获取：下一个交易日
	 */
	public String getNextTrd() {
		return nextTrd;
	}
	/**
	 * 设置：是否本周最后一个交易日
	 */
	public void setIsWeekEnd(Integer isWeekEnd) {
		this.isWeekEnd = isWeekEnd;
	}
	/**
	 * 获取：是否本周最后一个交易日
	 */
	public Integer getIsWeekEnd() {
		return isWeekEnd;
	}
	/**
	 * 设置：是否本月最后一个交易日
	 */
	public void setIsMonthEnd(Integer isMonthEnd) {
		this.isMonthEnd = isMonthEnd;
	}
	/**
	 * 获取：是否本月最后一个交易日
	 */
	public Integer getIsMonthEnd() {
		return isMonthEnd;
	}
	/**
	 * 设置：是否本年最后一个交易日
	 */
	public void setIsYearEnd(Integer isYearEnd) {
		this.isYearEnd = isYearEnd;
	}
	/**
	 * 获取：是否本年最后一个交易日
	 */
	public Integer getIsYearEnd() {
		return isYearEnd;
	}
	/**
	 * 设置：上周最后一个交易日
	 */
	public void setLastWeekTrd(String lastWeekTrd) {
		this.lastWeekTrd = lastWeekTrd;
	}
	/**
	 * 获取：上周最后一个交易日
	 */
	public String getLastWeekTrd() {
		return lastWeekTrd;
	}
	/**
	 * 设置：上月最后一个交易日
	 */
	public void setLastMonthTrd(String lastMonthTrd) {
		this.lastMonthTrd = lastMonthTrd;
	}
	/**
	 * 获取：上月最后一个交易日
	 */
	public String getLastMonthTrd() {
		return lastMonthTrd;
	}
	/**
	 * 设置：上年最后一个交易日
	 */
	public void setLastYearTrd(String lastYearTrd) {
		this.lastYearTrd = lastYearTrd;
	}
	/**
	 * 获取：上年最后一个交易日
	 */
	public String getLastYearTrd() {
		return lastYearTrd;
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
	/**
	 * 设置：外部系统时间
	 */
	public void setExtTime(String extTime) {
		this.extTime = extTime;
	}
	/**
	 * 获取：外部系统时间
	 */
	public String getExtTime() {
		return extTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}

    public String getFirstTrdOfWk() {
        return firstTrdOfWk;
    }

    public void setFirstTrdOfWk(String firstTrdOfWk) {
        this.firstTrdOfWk = firstTrdOfWk;
    }

    public String getLastTrdOfWk() {
        return lastTrdOfWk;
    }

    public void setLastTrdOfWk(String lastTrdOfWk) {
        this.lastTrdOfWk = lastTrdOfWk;
    }

    public String getFirstTrdOfMt() {
        return firstTrdOfMt;
    }

    public void setFirstTrdOfMt(String firstTrdOfMt) {
        this.firstTrdOfMt = firstTrdOfMt;
    }

    public String getLastTrdOfMt() {
        return lastTrdOfMt;
    }

    public void setLastTrdOfMt(String lastTrdOfMt) {
        this.lastTrdOfMt = lastTrdOfMt;
    }

    public String getFirstTrdOfYear() {
        return firstTrdOfYear;
    }

    public void setFirstTrdOfYear(String firstTrdOfYear) {
        this.firstTrdOfYear = firstTrdOfYear;
    }

    public String getLastTrdOfYear() {
        return lastTrdOfYear;
    }

    public void setLastTrdOfYear(String lastTrdOfYear) {
        this.lastTrdOfYear = lastTrdOfYear;
    }

    private String firstTrdOfWk;
    private String lastTrdOfWk;

    private String firstTrdOfMt;
    private String lastTrdOfMt;

    private String firstTrdOfYear;
    private String lastTrdOfYear;
}
