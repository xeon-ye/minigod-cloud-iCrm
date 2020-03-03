package com.minigod.persist.po;
import com.minigod.persist.tables.TFeatTask;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 功勋任务
 */
@Entity(table=TFeatTask.class)
public class FeatTask implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer featTastId;
	private Integer featId;
	private String taskName;//任务名称
	private Integer targeValue;//目标值
	private Integer reward;//奖励

    public Integer getFeatTastId () {
        return featTastId;
    }

    public void setFeatTastId (Integer featTastId) {
        this.featTastId = featTastId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getTaskName () {
        return taskName;
    }

    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public Integer getTargeValue () {
        return targeValue;
    }

    public void setTargeValue (Integer targeValue) {
        this.targeValue = targeValue;
    }

    public Integer getReward () {
        return reward;
    }

    public void setReward (Integer reward) {
        this.reward = reward;
    }
}