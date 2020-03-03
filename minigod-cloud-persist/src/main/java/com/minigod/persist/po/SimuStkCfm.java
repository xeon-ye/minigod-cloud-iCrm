package com.minigod.persist.po;
import com.minigod.persist.tables.TSimuStkCfm;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSimuStkCfm.class)
public class SimuStkCfm implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer simuStkCfmId;//个股成交ID
	private Integer userId;//用户ID
	private Integer ptfId;//组合ID
	private Integer simuStkOrdId;//个股委托ID
	private String simuOrdSeq;
	private String exchangeType;
	private String stkCode;
	private String stkAcc;
	private String busType;//业务类别
	private String simuCfmSeq;
	private Date cfmTime;//成交时间
	private Date cfmTrd;//成交日期
	private Double cfmPrc;//成交价格
	private Double cfmQty;//成交数量
	private Double cfmAmt;//成交金额
	private Double cfmFee;//交易佣金
	private Double cfmTax;//印花税
	private Double cfmTransferFee;//过户费
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getSimuStkCfmId () {
        return simuStkCfmId;
    }

    public void setSimuStkCfmId (Integer simuStkCfmId) {
        this.simuStkCfmId = simuStkCfmId;
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

    public Integer getSimuStkOrdId () {
        return simuStkOrdId;
    }

    public void setSimuStkOrdId (Integer simuStkOrdId) {
        this.simuStkOrdId = simuStkOrdId;
    }

    public String getSimuOrdSeq () {
        return simuOrdSeq;
    }

    public void setSimuOrdSeq (String simuOrdSeq) {
        this.simuOrdSeq = simuOrdSeq;
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

    public String getSimuCfmSeq () {
        return simuCfmSeq;
    }

    public void setSimuCfmSeq (String simuCfmSeq) {
        this.simuCfmSeq = simuCfmSeq;
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
}