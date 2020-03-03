package com.minigod.persist.po;
import com.minigod.persist.tables.TAdNiuInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdNiuInfo.class)
public class AdNiuInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer niuId;//主键
	private Integer adId;//广告id
	private Integer userId;//用户id
	private Integer ptfId;//组合id
	private Integer limitNum;//参与抢购好友数量
	private String yield;//M-月收益率,C-累计收益率
	private String niuDesc;//牛人简介
	private Integer createOpr;//创建人
	private Integer updateOpr;//更新人
	private Boolean isStatus;//0-不参加,1-参加
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getNiuId () {
        return niuId;
    }

    public void setNiuId (Integer niuId) {
        this.niuId = niuId;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getLimitNum () {
        return limitNum;
    }

    public void setLimitNum (Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getYield () {
        return yield;
    }

    public void setYield (String yield) {
        this.yield = yield;
    }

    public String getNiuDesc () {
        return niuDesc;
    }

    public void setNiuDesc (String niuDesc) {
        this.niuDesc = niuDesc;
    }

    public Integer getCreateOpr () {
        return createOpr;
    }

    public void setCreateOpr (Integer createOpr) {
        this.createOpr = createOpr;
    }

    public Integer getUpdateOpr () {
        return updateOpr;
    }

    public void setUpdateOpr (Integer updateOpr) {
        this.updateOpr = updateOpr;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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