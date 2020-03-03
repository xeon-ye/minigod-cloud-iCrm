package com.minigod.persist.po;
import com.minigod.persist.tables.TRealPtfBal;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealPtfBal.class)
public class RealPtfBal implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realPtfBalId;//记录ID
	private Integer userId;//用户ID
	private Integer ptfId;//组合ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private Boolean isFollow;//是否跟单组合
	private Boolean isCurrent;//是否当前持仓
	private Boolean isConfirm;//是否有个股成交过
	private Double followPct;//跟单市值比例
	private Integer ptfVersion;//组合版本号
	private Date firstBuyTime;//首次买入时间
	private Date balSyncTime;//组合持仓同步时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealPtfBalId () {
        return realPtfBalId;
    }

    public void setRealPtfBalId (Integer realPtfBalId) {
        this.realPtfBalId = realPtfBalId;
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

    public Integer getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrkCustid () {
        return brkCustid;
    }

    public void setBrkCustid (String brkCustid) {
        this.brkCustid = brkCustid;
    }

    public Boolean getIsFollow () {
        return isFollow;
    }

    public void setIsFollow (Boolean isFollow) {
        this.isFollow = isFollow;
    }

    public Boolean getIsCurrent () {
        return isCurrent;
    }

    public void setIsCurrent (Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Boolean getIsConfirm () {
        return isConfirm;
    }

    public void setIsConfirm (Boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Double getFollowPct () {
        return followPct;
    }

    public void setFollowPct (Double followPct) {
        this.followPct = followPct;
    }

    public Integer getPtfVersion () {
        return ptfVersion;
    }

    public void setPtfVersion (Integer ptfVersion) {
        this.ptfVersion = ptfVersion;
    }

    public Date getFirstBuyTime () {
        return firstBuyTime;
    }

    public void setFirstBuyTime (Date firstBuyTime) {
        this.firstBuyTime = firstBuyTime;
    }

    public Date getBalSyncTime () {
        return balSyncTime;
    }

    public void setBalSyncTime (Date balSyncTime) {
        this.balSyncTime = balSyncTime;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}