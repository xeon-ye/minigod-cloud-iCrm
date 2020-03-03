package com.minigod.persist.po;
import com.minigod.persist.tables.TGameFightStatistics;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 一战到底数据统计表
 */
@Entity(table=TGameFightStatistics.class)
public class GameFightStatistics implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer gameUserId;
	private Integer maxWinNum = 0;//最大连胜次数
	private Integer curWinNum = 0;//当前连胜次数
	private Date winUpdateTime;//连胜次数更新时间
	private Integer rightNum = 0;//猜对次数
	private Date rightUpdateTime;//猜对次数更新时间
	private Integer wrongNum = 0;//猜错次数
	private Integer joinNum = 0;//总参与竞猜次数
	private Integer lockVersion = 1;//乐观锁
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
    }

    public Integer getMaxWinNum () {
        return maxWinNum;
    }

    public void setMaxWinNum (Integer maxWinNum) {
        this.maxWinNum = maxWinNum;
    }

    public Integer getCurWinNum () {
        return curWinNum;
    }

    public void setCurWinNum (Integer curWinNum) {
        this.curWinNum = curWinNum;
    }

    public Date getWinUpdateTime () {
        return winUpdateTime;
    }

    public void setWinUpdateTime (Date winUpdateTime) {
        this.winUpdateTime = winUpdateTime;
    }

    public Integer getRightNum () {
        return rightNum;
    }

    public void setRightNum (Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Date getRightUpdateTime () {
        return rightUpdateTime;
    }

    public void setRightUpdateTime (Date rightUpdateTime) {
        this.rightUpdateTime = rightUpdateTime;
    }

    public Integer getWrongNum () {
        return wrongNum;
    }

    public void setWrongNum (Integer wrongNum) {
        this.wrongNum = wrongNum;
    }

    public Integer getJoinNum () {
        return joinNum;
    }

    public void setJoinNum (Integer joinNum) {
        this.joinNum = joinNum;
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