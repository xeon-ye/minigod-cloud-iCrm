package com.minigod.persist.po;
import com.minigod.persist.tables.TUserStockUpDown;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 看涨看跌
 */
@Entity(table=TUserStockUpDown.class)
public class UserStockUpDown implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;
	private String assetId;//资产id
	private Integer isup;//1、涨 0、跌
	private Double cost;//当时成本价
	private Date createTime;
	private Date updateTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Integer getIsup () {
        return isup;
    }

    public void setIsup (Integer isup) {
        this.isup = isup;
    }

    public Double getCost () {
        return cost;
    }

    public void setCost (Double cost) {
        this.cost = cost;
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