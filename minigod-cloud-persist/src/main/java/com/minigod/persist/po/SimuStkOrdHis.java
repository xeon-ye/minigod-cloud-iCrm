package com.minigod.persist.po;
import com.minigod.persist.tables.TSimuStkOrdHis;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSimuStkOrdHis.class)
public class SimuStkOrdHis implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer simuStkOrdId;//个股委托ID
	private Integer simuPtfTransId;//组合交易ID
	private String assetId;
	private Integer userId;//用户ID
	private Integer ptfId;//组合ID
	private String exchangeType;
	private String stkCode;
	private String busType;//业务类别
	private String priceType;//报价方式
	private Double ordQty;//委托数量
	private Double ordPrc;//委托价格
	private String orgSimuOrdSeq;
	private Date orderTrd;//委托交易日
	private String simuOrdSeq;
	private Integer innerRetCode;//内部返回码
	private String outRetCode;
	private String outRetMsg;
	private String stkDisplayStatus;//委托展示状态
	private String stkSendStatus;//委托发送状态
	private String stkFinishStatus;//委托结束状态
	private String simuStkOrderStatus;//模拟委托状态
	private Double cfmQty;//成交数量
	private Double cfmPrc;//平均价格
	private Double cfmAmt;//成交金额
	private Double wthQty;//撤单数量
	private Date stkSendTime;//发送时间
	private Date simuOrdTime;//模拟委托时间
	private Date stkSyncTime;//同步时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getSimuStkOrdId () {
        return simuStkOrdId;
    }

    public void setSimuStkOrdId (Integer simuStkOrdId) {
        this.simuStkOrdId = simuStkOrdId;
    }

    public Integer getSimuPtfTransId () {
        return simuPtfTransId;
    }

    public void setSimuPtfTransId (Integer simuPtfTransId) {
        this.simuPtfTransId = simuPtfTransId;
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

    public String getOrgSimuOrdSeq () {
        return orgSimuOrdSeq;
    }

    public void setOrgSimuOrdSeq (String orgSimuOrdSeq) {
        this.orgSimuOrdSeq = orgSimuOrdSeq;
    }

    public Date getOrderTrd () {
        return orderTrd;
    }

    public void setOrderTrd (Date orderTrd) {
        this.orderTrd = orderTrd;
    }

    public String getSimuOrdSeq () {
        return simuOrdSeq;
    }

    public void setSimuOrdSeq (String simuOrdSeq) {
        this.simuOrdSeq = simuOrdSeq;
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

    public String getSimuStkOrderStatus () {
        return simuStkOrderStatus;
    }

    public void setSimuStkOrderStatus (String simuStkOrderStatus) {
        this.simuStkOrderStatus = simuStkOrderStatus;
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

    public Date getSimuOrdTime () {
        return simuOrdTime;
    }

    public void setSimuOrdTime (Date simuOrdTime) {
        this.simuOrdTime = simuOrdTime;
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