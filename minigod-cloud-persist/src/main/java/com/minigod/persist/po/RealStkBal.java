package com.minigod.persist.po;
import com.minigod.persist.tables.TRealStkBal;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealStkBal.class)
public class RealStkBal implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realStkBalId;//记录ID
	private Integer userId;//用户ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String assetId;
	private Integer ptfId;//组合ID
	private Boolean isCurrent;//是否当前持仓
	private Boolean isConfirm;//是否成交过
	private String depositAcc;
	private String exchangeType;
	private String stkCode;
	private String stkAcc;
	private Date syncTime;//同步时间
	private Double totalBal;//总余额
	private Double avalBal;//可用余额
	private Double buyFrozen;//买入待交收
	private Double sellFrozen;//卖出冻结
	private Double othFrozen;//异常冻结
	private Double brkHoldPrice;//券商端持仓成本价
	private Double brkBuyPrice;//券商端买入成本价
	private String ccyType;//币种
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealStkBalId () {
        return realStkBalId;
    }

    public void setRealStkBalId (Integer realStkBalId) {
        this.realStkBalId = realStkBalId;
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

    public Boolean getIsConfirm () {
        return isConfirm;
    }

    public void setIsConfirm (Boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getDepositAcc () {
        return depositAcc;
    }

    public void setDepositAcc (String depositAcc) {
        this.depositAcc = depositAcc;
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

    public String getStkAcc () {
        return stkAcc;
    }

    public void setStkAcc (String stkAcc) {
        this.stkAcc = stkAcc;
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

    public Double getBuyFrozen () {
        return buyFrozen;
    }

    public void setBuyFrozen (Double buyFrozen) {
        this.buyFrozen = buyFrozen;
    }

    public Double getSellFrozen () {
        return sellFrozen;
    }

    public void setSellFrozen (Double sellFrozen) {
        this.sellFrozen = sellFrozen;
    }

    public Double getOthFrozen () {
        return othFrozen;
    }

    public void setOthFrozen (Double othFrozen) {
        this.othFrozen = othFrozen;
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

    public String getCcyType () {
        return ccyType;
    }

    public void setCcyType (String ccyType) {
        this.ccyType = ccyType;
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