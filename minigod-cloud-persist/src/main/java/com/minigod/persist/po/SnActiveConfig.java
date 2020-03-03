package com.minigod.persist.po;
import com.minigod.persist.tables.TSnActiveConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 开户活动配置表
 */
@Entity(table=TSnActiveConfig.class)
public class SnActiveConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer activeConfigId;
	private Integer activeType;//1、开户 2、入金
	private Double startValue;
	private Double endValue;
	private Integer freeDay;//免佣天数
	private Integer quotaMonth;//实时行情月数
	private Date startTime;//活动开始日期
	private Date endTime;//活动结束日期

    public Integer getActiveConfigId () {
        return activeConfigId;
    }

    public void setActiveConfigId (Integer activeConfigId) {
        this.activeConfigId = activeConfigId;
    }

    public Integer getActiveType () {
        return activeType;
    }

    public void setActiveType (Integer activeType) {
        this.activeType = activeType;
    }

    public Double getStartValue () {
        return startValue;
    }

    public void setStartValue (Double startValue) {
        this.startValue = startValue;
    }

    public Double getEndValue () {
        return endValue;
    }

    public void setEndValue (Double endValue) {
        this.endValue = endValue;
    }

    public Integer getFreeDay () {
        return freeDay;
    }

    public void setFreeDay (Integer freeDay) {
        this.freeDay = freeDay;
    }

    public Integer getQuotaMonth () {
        return quotaMonth;
    }

    public void setQuotaMonth (Integer quotaMonth) {
        this.quotaMonth = quotaMonth;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }
}