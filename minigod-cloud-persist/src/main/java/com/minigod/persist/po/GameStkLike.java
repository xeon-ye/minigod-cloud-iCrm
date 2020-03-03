package com.minigod.persist.po;
import com.minigod.persist.tables.TGameStkLike;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGameStkLike.class)
public class GameStkLike implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer gameStkLikeId;
	private Integer gameStkId;//赛事个股id
	private Integer gameUserId;//点赞用户id
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getGameStkLikeId () {
        return gameStkLikeId;
    }

    public void setGameStkLikeId (Integer gameStkLikeId) {
        this.gameStkLikeId = gameStkLikeId;
    }

    public Integer getGameStkId () {
        return gameStkId;
    }

    public void setGameStkId (Integer gameStkId) {
        this.gameStkId = gameStkId;
    }

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
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