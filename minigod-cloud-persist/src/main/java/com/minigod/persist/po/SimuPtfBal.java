package com.minigod.persist.po;
import com.minigod.persist.tables.TSimuPtfBal;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 模拟组合持仓
 */
@Entity(table=TSimuPtfBal.class)
public class SimuPtfBal implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer simuPtfBalId;//记录ID
	private Integer userId;//用户ID
	private Integer ptfId;//组合ID
	private String simuAcc;
	private Double initBal = 1000000.0000d;//初始金额
	private Double ttlBal;//模拟组合当前资金
	private Double avlBal;//模拟组合可用资金
	private Date balSyncTime;//组合持仓同步时间
	private Integer syncInterval;//上次同步间隔
	private Date syncBeginTime;//下次同步开始时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getSimuPtfBalId () {
        return simuPtfBalId;
    }

    public void setSimuPtfBalId (Integer simuPtfBalId) {
        this.simuPtfBalId = simuPtfBalId;
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

    public String getSimuAcc () {
        return simuAcc;
    }

    public void setSimuAcc (String simuAcc) {
        this.simuAcc = simuAcc;
    }

    public Double getInitBal () {
        return initBal;
    }

    public void setInitBal (Double initBal) {
        this.initBal = initBal;
    }

    public Double getTtlBal () {
        return ttlBal;
    }

    public void setTtlBal (Double ttlBal) {
        this.ttlBal = ttlBal;
    }

    public Double getAvlBal () {
        return avlBal;
    }

    public void setAvlBal (Double avlBal) {
        this.avlBal = avlBal;
    }

    public Date getBalSyncTime () {
        return balSyncTime;
    }

    public void setBalSyncTime (Date balSyncTime) {
        this.balSyncTime = balSyncTime;
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