package com.minigod.persist.po;
import com.minigod.persist.tables.TSnAchieveLog;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 积分记录表
 */
@Entity(table=TSnAchieveLog.class)
public class SnAchieveLog implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer achieveLogId;
	private Integer userId;
	private Long taskId;//任务id
	private String taskName;//任务名称
	private Integer coin;//任务完成可以领取的金币值
	private Integer experience;//任务完成可以领取的经验值
	private Date createTime;

    public Integer getAchieveLogId () {
        return achieveLogId;
    }

    public void setAchieveLogId (Integer achieveLogId) {
        this.achieveLogId = achieveLogId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Long getTaskId () {
        return taskId;
    }

    public void setTaskId (Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName () {
        return taskName;
    }

    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public Integer getCoin () {
        return coin;
    }

    public void setCoin (Integer coin) {
        this.coin = coin;
    }

    public Integer getExperience () {
        return experience;
    }

    public void setExperience (Integer experience) {
        this.experience = experience;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}