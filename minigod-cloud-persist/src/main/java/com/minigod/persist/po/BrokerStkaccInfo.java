package com.minigod.persist.po;
import com.minigod.persist.tables.TBrokerStkaccInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TBrokerStkaccInfo.class)
public class BrokerStkaccInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer stkaccId;//账户id
	private Integer userId;//用户id
	private Integer brokerId;//券商id
	private String brkCustid;
	private String exchangeType;
	private String brkExchangeType;
	private String stkacc;
	private String stkaccName;
	private String stkaccType;//股东账号类型
	private String depositAcc;
	private Date openDate;//开户日期
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getStkaccId () {
        return stkaccId;
    }

    public void setStkaccId (Integer stkaccId) {
        this.stkaccId = stkaccId;
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

    public String getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getBrkExchangeType () {
        return brkExchangeType;
    }

    public void setBrkExchangeType (String brkExchangeType) {
        this.brkExchangeType = brkExchangeType;
    }

    public String getStkacc () {
        return stkacc;
    }

    public void setStkacc (String stkacc) {
        this.stkacc = stkacc;
    }

    public String getStkaccName () {
        return stkaccName;
    }

    public void setStkaccName (String stkaccName) {
        this.stkaccName = stkaccName;
    }

    public String getStkaccType () {
        return stkaccType;
    }

    public void setStkaccType (String stkaccType) {
        this.stkaccType = stkaccType;
    }

    public String getDepositAcc () {
        return depositAcc;
    }

    public void setDepositAcc (String depositAcc) {
        this.depositAcc = depositAcc;
    }

    public Date getOpenDate () {
        return openDate;
    }

    public void setOpenDate (Date openDate) {
        this.openDate = openDate;
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