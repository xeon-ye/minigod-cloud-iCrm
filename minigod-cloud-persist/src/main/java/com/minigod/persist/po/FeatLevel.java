package com.minigod.persist.po;
import com.minigod.persist.tables.TFeatLevel;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 功勋等级表
 */
@Entity(table=TFeatLevel.class)
public class FeatLevel implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer featLevelId;
	private Integer featId;//功勋id
	private Integer featLevel;//等级
	private Integer featLevelStart;//功勋等级开始值
	private Integer featLevelEnd;//功勋等级结束值

    public Integer getFeatLevelId () {
        return featLevelId;
    }

    public void setFeatLevelId (Integer featLevelId) {
        this.featLevelId = featLevelId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public Integer getFeatLevel () {
        return featLevel;
    }

    public void setFeatLevel (Integer featLevel) {
        this.featLevel = featLevel;
    }

    public Integer getFeatLevelStart () {
        return featLevelStart;
    }

    public void setFeatLevelStart (Integer featLevelStart) {
        this.featLevelStart = featLevelStart;
    }

    public Integer getFeatLevelEnd () {
        return featLevelEnd;
    }

    public void setFeatLevelEnd (Integer featLevelEnd) {
        this.featLevelEnd = featLevelEnd;
    }
}