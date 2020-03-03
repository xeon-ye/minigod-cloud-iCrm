package com.minigod.persist.po;
import com.minigod.persist.tables.TCashTrans;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TCashTrans.class)
public class CashTrans implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer transactionId;//交易请求Id
	private String srcSys;//请求来源系统
	private String srcBus;//请求来源业务
	private String srcTransId;//源系统客户端交易ID
	private String md5;//请求数据摘要
	private Date accountDate;//记账日期
	private Integer relaTransactionId;//业务关联的交易请求
	private String reverseFlag;//冲账标志
	private Integer reverseTransaction;//冲账关联交易ID
	private String remark;//备注
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getSrcSys () {
        return srcSys;
    }

    public void setSrcSys (String srcSys) {
        this.srcSys = srcSys;
    }

    public String getSrcBus () {
        return srcBus;
    }

    public void setSrcBus (String srcBus) {
        this.srcBus = srcBus;
    }

    public String getSrcTransId () {
        return srcTransId;
    }

    public void setSrcTransId (String srcTransId) {
        this.srcTransId = srcTransId;
    }

    public String getMd5 () {
        return md5;
    }

    public void setMd5 (String md5) {
        this.md5 = md5;
    }

    public Date getAccountDate () {
        return accountDate;
    }

    public void setAccountDate (Date accountDate) {
        this.accountDate = accountDate;
    }

    public Integer getRelaTransactionId () {
        return relaTransactionId;
    }

    public void setRelaTransactionId (Integer relaTransactionId) {
        this.relaTransactionId = relaTransactionId;
    }

    public String getReverseFlag () {
        return reverseFlag;
    }

    public void setReverseFlag (String reverseFlag) {
        this.reverseFlag = reverseFlag;
    }

    public Integer getReverseTransaction () {
        return reverseTransaction;
    }

    public void setReverseTransaction (Integer reverseTransaction) {
        this.reverseTransaction = reverseTransaction;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
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