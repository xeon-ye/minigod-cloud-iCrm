package com.minigod.persist.po;
import com.minigod.persist.tables.TUserBroker;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserBroker.class)
public class UserBroker implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userBrokerId;//用户使用券商ID
	private Integer userId;//用户id
	private Integer brokerId;//券商id
	private String brkCustid;
	private String custName;
	private Boolean isCurrent;//当前是否使用
	private String tradeNode;
	private String branchNo;
	private String depositAcc;
	private String ext;
	private Integer syncInterval;//上次同步间隔
	private Date syncBeginTime;//下次同步开始时间
	private Date firstLogin;//第一次登陆时间
	private Date lastLogin;//最后一次登录时间
	private Integer loginCount;//登录次数
	private Date createTime;//记录创建时间
	private Date updateTime;//记录更新时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getUserBrokerId () {
        return userBrokerId;
    }

    public void setUserBrokerId (Integer userBrokerId) {
        this.userBrokerId = userBrokerId;
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

    public String getCustName () {
        return custName;
    }

    public void setCustName (String custName) {
        this.custName = custName;
    }

    public Boolean getIsCurrent () {
        return isCurrent;
    }

    public void setIsCurrent (Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getTradeNode () {
        return tradeNode;
    }

    public void setTradeNode (String tradeNode) {
        this.tradeNode = tradeNode;
    }

    public String getBranchNo () {
        return branchNo;
    }

    public void setBranchNo (String branchNo) {
        this.branchNo = branchNo;
    }

    public String getDepositAcc () {
        return depositAcc;
    }

    public void setDepositAcc (String depositAcc) {
        this.depositAcc = depositAcc;
    }

    public String getExt () {
        return ext;
    }

    public void setExt (String ext) {
        this.ext = ext;
    }

    public Integer getSyncInterval () {
        return syncInterval;
    }

    public void setSyncInterval (Integer syncInterval) {
        this.syncInterval = syncInterval;
    }

    public Date getSyncBeginTime () {
        return syncBeginTime;
    }

    public void setSyncBeginTime (Date syncBeginTime) {
        this.syncBeginTime = syncBeginTime;
    }

    public Date getFirstLogin () {
        return firstLogin;
    }

    public void setFirstLogin (Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getLastLogin () {
        return lastLogin;
    }

    public void setLastLogin (Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginCount () {
        return loginCount;
    }

    public void setLoginCount (Integer loginCount) {
        this.loginCount = loginCount;
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