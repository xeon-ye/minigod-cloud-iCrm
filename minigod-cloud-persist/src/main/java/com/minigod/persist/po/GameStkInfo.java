package com.minigod.persist.po;
import com.minigod.persist.tables.TGameStkInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGameStkInfo.class)
public class GameStkInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer gameStkId;
	private String clientReqId;//请求唯一id
	private Integer gameEventId;//赛事id
	private Integer gameUserId;//参与人id
	private String assetId;//资产id
	private Double cfmPrice;//成交价格
	private String exchangeCode;//所属指数
	private Integer induCode;//所属行业
	private String reason;//推荐理由
	private Integer rank;//比赛排名
	private Double yield;//最终盈亏比例
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getGameStkId () {
        return gameStkId;
    }

    public void setGameStkId (Integer gameStkId) {
        this.gameStkId = gameStkId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Integer getGameEventId () {
        return gameEventId;
    }

    public void setGameEventId (Integer gameEventId) {
        this.gameEventId = gameEventId;
    }

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Double getCfmPrice () {
        return cfmPrice;
    }

    public void setCfmPrice (Double cfmPrice) {
        this.cfmPrice = cfmPrice;
    }

    public String getExchangeCode () {
        return exchangeCode;
    }

    public void setExchangeCode (String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public Integer getInduCode () {
        return induCode;
    }

    public void setInduCode (Integer induCode) {
        this.induCode = induCode;
    }

    public String getReason () {
        return reason;
    }

    public void setReason (String reason) {
        this.reason = reason;
    }

    public Integer getRank () {
        return rank;
    }

    public void setRank (Integer rank) {
        this.rank = rank;
    }

    public Double getYield () {
        return yield;
    }

    public void setYield (Double yield) {
        this.yield = yield;
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