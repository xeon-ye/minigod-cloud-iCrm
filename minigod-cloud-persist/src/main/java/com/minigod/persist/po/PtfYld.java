package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfYld;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 组合指数增长率表
 */
@Entity(table=TPtfYld.class)
public class PtfYld implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfId;//组合ID
	private Double ptfIndex;//组合指数
	private Double dayYield;//日增长率
	private Double weekYield;//周增长率(七天)
	private Double monthYield;//月增长率(从上个月的同一天至今天)
	private Double yearYield;//年增长率(从上一年的同一天至今天)
	private Double natureWeekYield = 0.0000d;//周增长率(上周日至今天)
	private Double natureMonthYield = 0.0000d;//月增长率(上个月最后一天至今天)
	private Double natureYearYield = 0.0000d;//年增长率(去年最后一天至今天)
	private Double sinceCreateYield;//创建以来的增长率
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Double getPtfIndex () {
        return ptfIndex;
    }

    public void setPtfIndex (Double ptfIndex) {
        this.ptfIndex = ptfIndex;
    }

    public Double getDayYield () {
        return dayYield;
    }

    public void setDayYield (Double dayYield) {
        this.dayYield = dayYield;
    }

    public Double getWeekYield () {
        return weekYield;
    }

    public void setWeekYield (Double weekYield) {
        this.weekYield = weekYield;
    }

    public Double getMonthYield () {
        return monthYield;
    }

    public void setMonthYield (Double monthYield) {
        this.monthYield = monthYield;
    }

    public Double getYearYield () {
        return yearYield;
    }

    public void setYearYield (Double yearYield) {
        this.yearYield = yearYield;
    }

    public Double getNatureWeekYield () {
        return natureWeekYield;
    }

    public void setNatureWeekYield (Double natureWeekYield) {
        this.natureWeekYield = natureWeekYield;
    }

    public Double getNatureMonthYield () {
        return natureMonthYield;
    }

    public void setNatureMonthYield (Double natureMonthYield) {
        this.natureMonthYield = natureMonthYield;
    }

    public Double getNatureYearYield () {
        return natureYearYield;
    }

    public void setNatureYearYield (Double natureYearYield) {
        this.natureYearYield = natureYearYield;
    }

    public Double getSinceCreateYield () {
        return sinceCreateYield;
    }

    public void setSinceCreateYield (Double sinceCreateYield) {
        this.sinceCreateYield = sinceCreateYield;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}