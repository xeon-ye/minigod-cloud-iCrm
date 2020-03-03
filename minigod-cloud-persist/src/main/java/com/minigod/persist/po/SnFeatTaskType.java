package com.minigod.persist.po;
import com.minigod.persist.tables.TSnFeatTaskType;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 功勋任务类型表
 */
@Entity(table=TSnFeatTaskType.class)
public class SnFeatTaskType implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer featTaskTypeId;
	private Integer featId;//功勋id
	private String taskType;//任务的任务类型（任务类型可以理解为任务编码，即对应具体的任务）
	private String taskTypeDesc;//任务类型描述
	private Integer featValue;//完成该任务类型对应的功勋值
	private String creator;//创建者
	private Date createTime;//创建时间
	private String modifier;//修改者
	private Date updateTime;//修改时间

    public Integer getFeatTaskTypeId () {
        return featTaskTypeId;
    }

    public void setFeatTaskTypeId (Integer featTaskTypeId) {
        this.featTaskTypeId = featTaskTypeId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getTaskType () {
        return taskType;
    }

    public void setTaskType (String taskType) {
        this.taskType = taskType;
    }

    public String getTaskTypeDesc () {
        return taskTypeDesc;
    }

    public void setTaskTypeDesc (String taskTypeDesc) {
        this.taskTypeDesc = taskTypeDesc;
    }

    public Integer getFeatValue () {
        return featValue;
    }

    public void setFeatValue (Integer featValue) {
        this.featValue = featValue;
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