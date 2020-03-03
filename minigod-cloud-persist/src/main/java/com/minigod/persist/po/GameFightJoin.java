package com.minigod.persist.po;
import com.minigod.persist.tables.TGameFightJoin;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 一战到底用户参赛表
 */
@Entity(table=TGameFightJoin.class)
public class GameFightJoin implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer fightJoinId;//一战到底用户参赛表 参赛id
	private Integer fightEventId;//赛事id
	private Integer gameUserId;//参与人id
	private Integer latestGuessId;//最新的竞猜id
	private Integer maxWinNum = 0;//连胜次数
	private Integer rank;//排名
	private Integer status = 1;//用户参赛状态 1进行中 9结束
	private Integer endType;//结束类型 猜错0 猜对1，即得冠军赛事结束 缺席2
	private Integer lockVersion;//乐观锁
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getFightJoinId () {
        return fightJoinId;
    }

    public void setFightJoinId (Integer fightJoinId) {
        this.fightJoinId = fightJoinId;
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

    public Integer getLatestGuessId () {
        return latestGuessId;
    }

    public void setLatestGuessId (Integer latestGuessId) {
        this.latestGuessId = latestGuessId;
    }

    public Integer getMaxWinNum () {
        return maxWinNum;
    }

    public void setMaxWinNum (Integer maxWinNum) {
        this.maxWinNum = maxWinNum;
    }

    public Integer getRank () {
        return rank;
    }

    public void setRank (Integer rank) {
        this.rank = rank;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Integer getEndType () {
        return endType;
    }

    public void setEndType (Integer endType) {
        this.endType = endType;
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