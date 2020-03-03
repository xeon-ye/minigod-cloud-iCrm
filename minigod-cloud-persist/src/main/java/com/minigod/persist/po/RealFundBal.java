package com.minigod.persist.po;
import com.minigod.persist.tables.TRealFundBal;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealFundBal.class)
public class RealFundBal implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realFundBalId;//资金账户ID
	private Integer userId;//用户ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String depositAcc;
	private String ccyType;//币种
	private Boolean isDefault;//是否主资金账号
	private Double totalBal;//资金总额
	private Double avaBal;//可用资金
	private Double cashBal;//可取资金
	private Double totalMktval;//股票市值
	private Double totalAsset;//总资产
	private Date syncTime;//同步时间
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealFundBalId () {
        return realFundBalId;
    }

    public void setRealFundBalId (Integer realFundBalId) {
        this.realFundBalId = realFundBalId;
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

    public String getDepositAcc () {
        return depositAcc;
    }

    public void setDepositAcc (String depositAcc) {
        this.depositAcc = depositAcc;
    }

    public String getCcyType () {
        return ccyType;
    }

    public void setCcyType (String ccyType) {
        this.ccyType = ccyType;
    }

    public Boolean getIsDefault () {
        return isDefault;
    }

    public void setIsDefault (Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Double getTotalBal () {
        return totalBal;
    }

    public void setTotalBal (Double totalBal) {
        this.totalBal = totalBal;
    }

    public Double getAvaBal () {
        return avaBal;
    }

    public void setAvaBal (Double avaBal) {
        this.avaBal = avaBal;
    }

    public Double getCashBal () {
        return cashBal;
    }

    public void setCashBal (Double cashBal) {
        this.cashBal = cashBal;
    }

    public Double getTotalMktval () {
        return totalMktval;
    }

    public void setTotalMktval (Double totalMktval) {
        this.totalMktval = totalMktval;
    }

    public Double getTotalAsset () {
        return totalAsset;
    }

    public void setTotalAsset (Double totalAsset) {
        this.totalAsset = totalAsset;
    }

    public Date getSyncTime () {
        return syncTime;
    }

    public void setSyncTime (Date syncTime) {
        this.syncTime = syncTime;
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