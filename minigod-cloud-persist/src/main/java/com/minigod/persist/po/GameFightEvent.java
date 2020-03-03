package com.minigod.persist.po;
import com.minigod.persist.tables.TGameFightEvent;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 一战到底赛事表
 */
@Entity(table=TGameFightEvent.class)
public class GameFightEvent implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer fightEventId;//一战到底赛事表 赛事id
	private Integer phaseNum;//第N期
	private String eventName;//赛事名称
	private Date startTime;//比赛开始时间
	private Date endTime;//比赛结束时间
	private Integer lowerLimit;//参数人数下限
	private Integer upperLimit;//参赛人数上限
	private BigDecimal prize;//奖金
	private Integer winner;//冠军用户id
	private Integer totalNum = 0;//已参赛总人数
	private Integer remainNum;//剩余人数
	private Integer runDay = 0;//持续交易日
	private Integer eventStatus = 0;//赛事状态 默认0-未开始 1-进行中 2-作废 3-结束
	private Integer lockVersion;//乐观锁
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getFightEventId () {
        return fightEventId;
    }

    public void setFightEventId (Integer fightEventId) {
        this.fightEventId = fightEventId;
    }

    public Integer getPhaseNum () {
        return phaseNum;
    }

    public void setPhaseNum (Integer phaseNum) {
        this.phaseNum = phaseNum;
    }

    public String getEventName () {
        return eventName;
    }

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLowerLimit () {
        return lowerLimit;
    }

    public void setLowerLimit (Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Integer getUpperLimit () {
        return upperLimit;
    }

    public void setUpperLimit (Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public BigDecimal getPrize () {
        return prize;
    }

    public void setPrize (BigDecimal prize) {
        this.prize = prize;
    }

    public Integer getWinner () {
        return winner;
    }

    public void setWinner (Integer winner) {
        this.winner = winner;
    }

    public Integer getTotalNum () {
        return totalNum;
    }

    public void setTotalNum (Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getRemainNum () {
        return remainNum;
    }

    public void setRemainNum (Integer remainNum) {
        this.remainNum = remainNum;
    }

    public Integer getRunDay () {
        return runDay;
    }

    public void setRunDay (Integer runDay) {
        this.runDay = runDay;
    }

    public Integer getEventStatus () {
        return eventStatus;
    }

    public void setEventStatus (Integer eventStatus) {
        this.eventStatus = eventStatus;
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