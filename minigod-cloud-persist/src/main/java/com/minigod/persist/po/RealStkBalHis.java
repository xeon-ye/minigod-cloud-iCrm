package com.minigod.persist.po;
import com.minigod.persist.tables.TRealStkBalHis;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealStkBalHis.class)
public class RealStkBalHis implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realStkBalHisId;//记录ID
	private Integer userId;//用户ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String assetId;
	private Date effectiveFrom;//有效起始时间
	private Date effectiveTo;//有效截止时间
	private Integer ptfId;//组合ID
	private Boolean isCurrent;//是否当前持仓
	private Double totalBal;//总余额
	private Double avalBal;//可用余额
	private Double brkHoldPrice;//券商端持仓成本价
	private Double brkBuyPrice;//券商端买入成本价
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//观锁版本号

    public Integer getRealStkBalHisId () {
        return realStkBalHisId;
    }

    public void setRealStkBalHisId (Integer realStkBalHisId) {
        this.realStkBalHisId = realStkBalHisId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
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

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Date getEffectiveFrom () {
        return effectiveFrom;
    }

    public void setEffectiveFrom (Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveTo () {
        return effectiveTo;
    }

    public void setEffectiveTo (Date effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Boolean getIsCurrent () {
        return isCurrent;
    }

    public void setIsCurrent (Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Double getTotalBal () {
        return totalBal;
    }

    public void setTotalBal (Double totalBal) {
        this.totalBal = totalBal;
    }

    public Double getAvalBal () {
        return avalBal;
    }

    public void setAvalBal (Double avalBal) {
        this.avalBal = avalBal;
    }

    public Double getBrkHoldPrice () {
        return brkHoldPrice;
    }

    public void setBrkHoldPrice (Double brkHoldPrice) {
        this.brkHoldPrice = brkHoldPrice;
    }

    public Double getBrkBuyPrice () {
        return brkBuyPrice;
    }

    public void setBrkBuyPrice (Double brkBuyPrice) {
        this.brkBuyPrice = brkBuyPrice;
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