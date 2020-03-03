package com.minigod.persist.po;
import com.minigod.persist.tables.TGameFightGuess;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 一战到底竞猜记录表
 */
@Entity(table=TGameFightGuess.class)
public class GameFightGuess implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer fightGuessId;//竞猜记录表 竞猜id
	private Integer fightEventId;//赛事id
	private Integer gameUserId;//参与人id
	private Date guessDate;//竞猜日期 竞猜哪一个交易日涨或跌
	private Integer guessValue;//竞猜值 跌0 涨1
	private Integer isRight;//是否正确 错误0 正确1
	private Integer lockVersion;//乐观锁
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getFightGuessId () {
        return fightGuessId;
    }

    public void setFightGuessId (Integer fightGuessId) {
        this.fightGuessId = fightGuessId;
    }

    public Integer getFightEventId () {
        return fightEventId;
    }

    public void setFightEventId (Integer fightEventId) {
        this.fightEventId = fightEventId;
    }

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
    }

    public Date getGuessDate () {
        return guessDate;
    }

    public void setGuessDate (Date guessDate) {
        this.guessDate = guessDate;
    }

    public Integer getGuessValue () {
        return guessValue;
    }

    public void setGuessValue (Integer guessValue) {
        this.guessValue = guessValue;
    }

    public Integer getIsRight () {
        return isRight;
    }

    public void setIsRight (Integer isRight) {
        this.isRight = isRight;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
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