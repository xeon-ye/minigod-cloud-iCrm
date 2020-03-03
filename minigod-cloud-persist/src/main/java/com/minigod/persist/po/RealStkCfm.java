package com.minigod.persist.po;
import com.minigod.persist.tables.TRealStkCfm;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealStkCfm.class)
public class RealStkCfm implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realStkCfmId;//个股成交ID
	private Integer userId;//用户ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String brkOrdSeq;
	private String depositAcc;
	private String exchangeType;
	private String stkCode;
	private String stkAcc;
	private String busType;//业务类别(B-买入,S-卖出,W-撤单)
	private String cfmStatus;//成交状态
	private String brkCfmSeq;
	private Date cfmTime;//成交时间
	private Date cfmTrd;//成交日期
	private Double cfmPrc;//成交价格
	private Double cfmQty;//成交数量
	private Double cfmAmt;//成交金额
	private Double cfmFee;//手续费
	private Double cfmTax;//印花税
	private Double cfmTransferFee;//过户费
	private Double cfmClearFee;//清算费
	private Double cfmRegularFee;//交易规费
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealStkCfmId () {
        return realStkCfmId;
    }

    public void setRealStkCfmId (Integer realStkCfmId) {
        this.realStkCfmId = realStkCfmId;
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

    public String getBrkOrdSeq () {
        return brkOrdSeq;
    }

    public void setBrkOrdSeq (String brkOrdSeq) {
        this.brkOrdSeq = brkOrdSeq;
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

    public String getBusType () {
        return busType;
    }

    public void setBusType (String busType) {
        this.busType = busType;
    }

    public String getCfmStatus () {
        return cfmStatus;
    }

    public void setCfmStatus (String cfmStatus) {
        this.cfmStatus = cfmStatus;
    }

    public String getBrkCfmSeq () {
        return brkCfmSeq;
    }

    public void setBrkCfmSeq (String brkCfmSeq) {
        this.brkCfmSeq = brkCfmSeq;
    }

    public Date getCfmTime () {
        return cfmTime;
    }

    public void setCfmTime (Date cfmTime) {
        this.cfmTime = cfmTime;
    }

    public Date getCfmTrd () {
        return cfmTrd;
    }

    public void setCfmTrd (Date cfmTrd) {
        this.cfmTrd = cfmTrd;
    }

    public Double getCfmPrc () {
        return cfmPrc;
    }

    public void setCfmPrc (Double cfmPrc) {
        this.cfmPrc = cfmPrc;
    }

    public Double getCfmQty () {
        return cfmQty;
    }

    public void setCfmQty (Double cfmQty) {
        this.cfmQty = cfmQty;
    }

    public Double getCfmAmt () {
        return cfmAmt;
    }

    public void setCfmAmt (Double cfmAmt) {
        this.cfmAmt = cfmAmt;
    }

    public Double getCfmFee () {
        return cfmFee;
    }

    public void setCfmFee (Double cfmFee) {
        this.cfmFee = cfmFee;
    }

    public Double getCfmTax () {
        return cfmTax;
    }

    public void setCfmTax (Double cfmTax) {
        this.cfmTax = cfmTax;
    }

    public Double getCfmTransferFee () {
        return cfmTransferFee;
    }

    public void setCfmTransferFee (Double cfmTransferFee) {
        this.cfmTransferFee = cfmTransferFee;
    }

    public Double getCfmClearFee () {
        return cfmClearFee;
    }

    public void setCfmClearFee (Double cfmClearFee) {
        this.cfmClearFee = cfmClearFee;
    }

    public Double getCfmRegularFee () {
        return cfmRegularFee;
    }

    public void setCfmRegularFee (Double cfmRegularFee) {
        this.cfmRegularFee = cfmRegularFee;
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