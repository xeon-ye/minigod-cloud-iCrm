package com.minigod.persist.po;
import com.minigod.persist.tables.TUserAchieve;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户成就
 */
@Entity(table=TUserAchieve.class)
public class UserAchieve implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userAchieveId;
	private Integer userId;
	private Integer featId;//功勋id
	private Integer level;//等级
	private Integer featValue;//经验值
	private Date createTime;
	private Date updateTime;

    public Integer getUserAchieveId () {
        return userAchieveId;
    }

    public void setUserAchieveId (Integer userAchieveId) {
        this.userAchieveId = userAchieveId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public Integer getLevel () {
        return level;
    }

    public void setLevel (Integer level) {
        this.level = level;
    }

    public Integer getFeatValue () {
        return featValue;
    }

    public void setFeatValue (Integer featValue) {
        this.featValue = featValue;
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