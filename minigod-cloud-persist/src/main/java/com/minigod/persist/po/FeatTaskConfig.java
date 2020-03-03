package com.minigod.persist.po;
import com.minigod.persist.tables.TFeatTaskConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TFeatTaskConfig.class)
public class FeatTaskConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer featTaskConfigId;
	private Integer featId;
	private String featTaskName;//任务名称
	private Integer featValue;//功勋值
	private String featTaskDesc;//任务描述

    public Integer getFeatTaskConfigId () {
        return featTaskConfigId;
    }

    public void setFeatTaskConfigId (Integer featTaskConfigId) {
        this.featTaskConfigId = featTaskConfigId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getFeatTaskName () {
        return featTaskName;
    }

    public void setFeatTaskName (String featTaskName) {
        this.featTaskName = featTaskName;
    }

    public Integer getFeatValue () {
        return featValue;
    }

    public void setFeatValue (Integer featValue) {
        this.featValue = featValue;
    }

    public String getFeatTaskDesc () {
        return featTaskDesc;
    }

    public void setFeatTaskDesc (String featTaskDesc) {
        this.featTaskDesc = featTaskDesc;
    }
}