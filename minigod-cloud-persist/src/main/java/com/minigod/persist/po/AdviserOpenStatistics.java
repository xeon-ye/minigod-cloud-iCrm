package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserOpenStatistics;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserOpenStatistics.class)
public class AdviserOpenStatistics implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserOpenStatsId;
	private Integer adviserUserId;//投顾用户id
	private Integer userId;//用户id
	private Integer times = 1;//次数
	private String openUrl;//开户url
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getAdviserOpenStatsId () {
        return adviserOpenStatsId;
    }

    public void setAdviserOpenStatsId (Integer adviserOpenStatsId) {
        this.adviserOpenStatsId = adviserOpenStatsId;
    }

    public Integer getAdviserUserId () {
        return adviserUserId;
    }

    public void setAdviserUserId (Integer adviserUserId) {
        this.adviserUserId = adviserUserId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getTimes () {
        return times;
    }

    public void setTimes (Integer times) {
        this.times = times;
    }

    public String getOpenUrl () {
        return openUrl;
    }

    public void setOpenUrl (String openUrl) {
        this.openUrl = openUrl;
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