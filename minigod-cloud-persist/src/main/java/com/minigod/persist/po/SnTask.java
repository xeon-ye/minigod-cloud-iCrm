package com.minigod.persist.po;
import com.minigod.persist.tables.TSnTask;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 功勋任务配置表
 */
@Entity(table=TSnTask.class)
public class SnTask implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer snTaskId;
	private String taskType;//任务的任务类型（任务类型可以理解为任务编码，即对应具体的任务）
	private String taskName;//任务名称
	private String taskTypeDesc;//任务类型描述
	private Integer featId;//功勋id
	private String eventCode;//任务所属的事件类型
	private String calType;//任务的计算类型
	private Integer targetNum;//目标数字
	private Integer experience;//任务完成可以领取的经验值（功勋值）
	private Integer coin;//任务完成可以领取的金币值
	private Boolean isStatus = true;//是否有效
	private String creator;//创建者
	private Date createTime;//创建时间
	private String modifier;//修改者
	private Date updateTime;//修改时间

    public Integer getSnTaskId () {
        return snTaskId;
    }

    public void setSnTaskId (Integer snTaskId) {
        this.snTaskId = snTaskId;
    }

    public String getTaskType () {
        return taskType;
    }

    public void setTaskType (String taskType) {
        this.taskType = taskType;
    }

    public String getTaskName () {
        return taskName;
    }

    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public String getTaskTypeDesc () {
        return taskTypeDesc;
    }

    public void setTaskTypeDesc (String taskTypeDesc) {
        this.taskTypeDesc = taskTypeDesc;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getEventCode () {
        return eventCode;
    }

    public void setEventCode (String eventCode) {
        this.eventCode = eventCode;
    }

    public String getCalType () {
        return calType;
    }

    public void setCalType (String calType) {
        this.calType = calType;
    }

    public Integer getTargetNum () {
        return targetNum;
    }

    public void setTargetNum (Integer targetNum) {
        this.targetNum = targetNum;
    }

    public Integer getExperience () {
        return experience;
    }

    public void setExperience (Integer experience) {
        this.experience = experience;
    }

    public Integer getCoin () {
        return coin;
    }

    public void setCoin (Integer coin) {
        this.coin = coin;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public String getCreator () {
        return creator;
    }

    public void setCreator (String creator) {
        this.creator = creator;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier () {
        return modifier;
    }

    public void setModifier (String modifier) {
        this.modifier = modifier;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}