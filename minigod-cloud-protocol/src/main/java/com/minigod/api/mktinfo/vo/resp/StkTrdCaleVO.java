package com.minigod.api.mktinfo.vo.resp;

import java.util.Date;

/**
 * Created by CaiJianbo on 2016/4/28 21:08.
 * minigod
 */
public class StkTrdCaleVO {
    private static final long serialVersionUID = 1L;

    private Integer calendarId;//交易日历ID
    private Date normalDate;//自然日期
    private String regionCode;//地区
    private Boolean isTradeDay = false;//当天是否交易日
    private Date lastTrd;//上一个交易日
    private Date nextTrd;//下一个交易日
    private Boolean isWeekEnd;//是否本周最后一个交易日
    private Boolean isMonthEnd;//是否本月最后一个交易日
    private Boolean isYearEnd;//是否本年最后一个交易日
    private Date lastWeekTrd;//上周最后一个交易日
    private Date lastMonthTrd;//上月最后一个交易日
    private Date lastYearTrd;//上年最后一个交易日
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private Date extTime;//外部系统时间
    private String remark;

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public Date getNormalDate() {
        return normalDate;
    }

    public void setNormalDate(Date normalDate) {
        this.normalDate = normalDate;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Boolean getIsTradeDay() {
        return isTradeDay;
    }

    public void setIsTradeDay(Boolean isTradeDay) {
        this.isTradeDay = isTradeDay;
    }

    public Date getLastTrd() {
        return lastTrd;
    }

    public void setLastTrd(Date lastTrd) {
        this.lastTrd = lastTrd;
    }

    public Date getNextTrd() {
        return nextTrd;
    }

    public void setNextTrd(Date nextTrd) {
        this.nextTrd = nextTrd;
    }

    public Boolean getIsWeekEnd() {
        return isWeekEnd;
    }

    public void setIsWeekEnd(Boolean isWeekEnd) {
        this.isWeekEnd = isWeekEnd;
    }

    public Boolean getIsMonthEnd() {
        return isMonthEnd;
    }

    public void setIsMonthEnd(Boolean isMonthEnd) {
        this.isMonthEnd = isMonthEnd;
    }

    public Boolean getIsYearEnd() {
        return isYearEnd;
    }

    public void setIsYearEnd(Boolean isYearEnd) {
        this.isYearEnd = isYearEnd;
    }

    public Date getLastWeekTrd() {
        return lastWeekTrd;
    }

    public void setLastWeekTrd(Date lastWeekTrd) {
        this.lastWeekTrd = lastWeekTrd;
    }

    public Date getLastMonthTrd() {
        return lastMonthTrd;
    }

    public void setLastMonthTrd(Date lastMonthTrd) {
        this.lastMonthTrd = lastMonthTrd;
    }

    public Date getLastYearTrd() {
        return lastYearTrd;
    }

    public void setLastYearTrd(Date lastYearTrd) {
        this.lastYearTrd = lastYearTrd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExtTime() {
        return extTime;
    }

    public void setExtTime(Date extTime) {
        this.extTime = extTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
