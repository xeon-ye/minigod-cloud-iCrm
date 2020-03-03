package com.minigod.persist.po;
import com.minigod.persist.tables.TRealStkOrd;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealStkOrd.class)
public class RealStkOrd implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realStkOrdId;//个股委托ID
	private Integer realPtfTransId;//组合交易ID
	private String assetId;
	private Integer userId;//用户ID
	private Integer ptfId;//组合ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String depositAcc;
	private String exchangeType;
	private String stkCode;
	private String stkAcc;
	private String busType;//业务类别
	private String priceType;//报价方式
	private Double ordQty;//委托数量
	private Double ordPrc;//委托价格
	private String orgBrkOrdSeq;
	private Date orderTrd;//委托交易日
	private String brkOrdSeq;
	private String brkContractSeq;
	private Integer innerRetCode;//内部返回码
	private String outRetCode;
	private String outRetMsg;
	private String stkDisplayStatus;//委托展示状态
	private String stkSendStatus;//委托发送状态
	private String stkFinishStatus;//委托结束状态
	private String brkStkOrderStatus;//券商端委托状态
	private Double ordAmt;//委托金额
	private Double ordFee;//预收费用
	private Double cfmQty;//成交数量
	private Double cfmPrc;//平均价格
	private Double cfmAmt;//成交金额
	private Double wthQty;//撤单数量
	private Date stkSendTime;//发送时间
	private Date brkOrdTime;//券商端委托时间
	private Date stkSyncTime;//同步时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealStkOrdId () {
        return realStkOrdId;
    }

    public void setRealStkOrdId (Integer realStkOrdId) {
        this.realStkOrdId = realStkOrdId;
    }

    public Integer getRealPtfTransId () {
        return realPtfTransId;
    }

    public void setRealPtfTransId (Integer realPtfTransId) {
        this.realPtfTransId = realPtfTransId;
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

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
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

    public String getPriceType () {
        return priceType;
    }

    public void setPriceType (String priceType) {
        this.priceType = priceType;
    }

    public Double getOrdQty () {
        return ordQty;
    }

    public void setOrdQty (Double ordQty) {
        this.ordQty = ordQty;
    }

    public Double getOrdPrc () {
        return ordPrc;
    }

    public void setOrdPrc (Double ordPrc) {
        this.ordPrc = ordPrc;
    }

    public String getOrgBrkOrdSeq () {
        return orgBrkOrdSeq;
    }

    public void setOrgBrkOrdSeq (String orgBrkOrdSeq) {
        this.orgBrkOrdSeq = orgBrkOrdSeq;
    }

    public Date getOrderTrd () {
        return orderTrd;
    }

    public void setOrderTrd (Date orderTrd) {
        this.orderTrd = orderTrd;
    }

    public String getBrkOrdSeq () {
        return brkOrdSeq;
    }

    public void setBrkOrdSeq (String brkOrdSeq) {
        this.brkOrdSeq = brkOrdSeq;
    }

    public String getBrkContractSeq () {
        return brkContractSeq;
    }

    public void setBrkContractSeq (String brkContractSeq) {
        this.brkContractSeq = brkContractSeq;
    }

    public Integer getInnerRetCode () {
        return innerRetCode;
    }

    public void setInnerRetCode (Integer innerRetCode) {
        this.innerRetCode = innerRetCode;
    }

    public String getOutRetCode () {
        return outRetCode;
    }

    public void setOutRetCode (String outRetCode) {
        this.outRetCode = outRetCode;
    }

    public String getOutRetMsg () {
        return outRetMsg;
    }

    public void setOutRetMsg (String outRetMsg) {
        this.outRetMsg = outRetMsg;
    }

    public String getStkDisplayStatus () {
        return stkDisplayStatus;
    }

    public void setStkDisplayStatus (String stkDisplayStatus) {
        this.stkDisplayStatus = stkDisplayStatus;
    }

    public String getStkSendStatus () {
        return stkSendStatus;
    }

    public void setStkSendStatus (String stkSendStatus) {
        this.stkSendStatus = stkSendStatus;
    }

    public String getStkFinishStatus () {
        return stkFinishStatus;
    }

    public void setStkFinishStatus (String stkFinishStatus) {
        this.stkFinishStatus = stkFinishStatus;
    }

    public String getBrkStkOrderStatus () {
        return brkStkOrderStatus;
    }

    public void setBrkStkOrderStatus (String brkStkOrderStatus) {
        this.brkStkOrderStatus = brkStkOrderStatus;
    }

    public Double getOrdAmt () {
        return ordAmt;
    }

    public void setOrdAmt (Double ordAmt) {
        this.ordAmt = ordAmt;
    }

    public Double getOrdFee () {
        return ordFee;
    }

    public void setOrdFee (Double ordFee) {
        this.ordFee = ordFee;
    }

    public Double getCfmQty () {
        return cfmQty;
    }

    public void setCfmQty (Double cfmQty) {
        this.cfmQty = cfmQty;
    }

    public Double getCfmPrc () {
        return cfmPrc;
    }

    public void setCfmPrc (Double cfmPrc) {
        this.cfmPrc = cfmPrc;
    }

    public Double getCfmAmt () {
        return cfmAmt;
    }

    public void setCfmAmt (Double cfmAmt) {
        this.cfmAmt = cfmAmt;
    }

    public Double getWthQty () {
        return wthQty;
    }

    public void setWthQty (Double wthQty) {
        this.wthQty = wthQty;
    }

    public Date getStkSendTime () {
        return stkSendTime;
    }

    public void setStkSendTime (Date stkSendTime) {
        this.stkSendTime = stkSendTime;
    }

    public Date getBrkOrdTime () {
        return brkOrdTime;
    }

    public void setBrkOrdTime (Date brkOrdTime) {
        this.brkOrdTime = brkOrdTime;
    }

    public Date getStkSyncTime () {
        return stkSyncTime;
    }

    public void setStkSyncTime (Date stkSyncTime) {
        this.stkSyncTime = stkSyncTime;
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