package com.minigod.persist.po;
import com.minigod.persist.tables.TSimuStkBal;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSimuStkBal.class)
public class SimuStkBal implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer simuStkBalId;//记录ID
	private Integer ptfId;//组合ID
	private String assetId;
	private Integer userId;//用户ID
	private Boolean isCurrent;//是否当前持仓
	private String exchangeType;
	private String stkCode;
	private Date syncTime;//同步时间
	private Double totalBal;//总余额
	private Double avalBal;//可用余额
	private Double simuBuyPrice;//模拟买入成本价
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getSimuStkBalId () {
        return simuStkBalId;
    }

    public void setSimuStkBalId (Integer simuStkBalId) {
        this.simuStkBalId = simuStkBalId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsCurrent () {
        return isCurrent;
    }

    public void setIsCurrent (Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getStkCode () {
        return stkCode;
    }

    public void setStkCode (String stkCode) {
        this.stkCode = stkCode;
    }

    public Date getSyncTime () {
        return syncTime;
    }

    public void setSyncTime (Date syncTime) {
        this.syncTime = syncTime;
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

    public Double getSimuBuyPrice () {
        return simuBuyPrice;
    }

    public void setSimuBuyPrice (Double simuBuyPrice) {
        this.simuBuyPrice = simuBuyPrice;
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