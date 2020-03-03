package com.minigod.persist.po;
import com.minigod.persist.tables.TGameEventInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGameEventInfo.class)
public class GameEventInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer gameEventId;
	private String clientReqId;//请求唯一id
	private Integer gameUserId;//发起人id
	private String eventName;//赛事名称
	private Date startTime;//比赛开始时间
	private Date endTime;//比赛结束时间
	private Integer limitNum;//参赛人数上限
	private Integer num;//已参赛人数
	private Integer eventStatus;//赛事状态(0-未开始,1-进行中,2-结束,3-作废)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getGameEventId () {
        return gameEventId;
    }

    public void setGameEventId (Integer gameEventId) {
        this.gameEventId = gameEventId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
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

    public Integer getLimitNum () {
        return limitNum;
    }

    public void setLimitNum (Integer limitNum) {
        this.limitNum = limitNum;
    }

    public Integer getNum () {
        return num;
    }

    public void setNum (Integer num) {
        this.num = num;
    }

    public Integer getEventStatus () {
        return eventStatus;
    }

    public void setEventStatus (Integer eventStatus) {
        this.eventStatus = eventStatus;
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