package com.minigod.persist.po;
import com.minigod.persist.tables.TBrokerDepositInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TBrokerDepositInfo.class)
public class BrokerDepositInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer brkDepositId;//资金账户id
	private Integer userId;//用户id
	private Integer brokerId;//券商id
	private String brkCustid;
	private String depositAcc;
	private String depositAccType;//资金账号类型
	private Boolean isDefault;//是否主资金账号
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getBrkDepositId () {
        return brkDepositId;
    }

    public void setBrkDepositId (Integer brkDepositId) {
        this.brkDepositId = brkDepositId;
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

    public String getDepositAccType () {
        return depositAccType;
    }

    public void setDepositAccType (String depositAccType) {
        this.depositAccType = depositAccType;
    }

    public Boolean getIsDefault () {
        return isDefault;
    }

    public void setIsDefault (Boolean isDefault) {
        this.isDefault = isDefault;
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