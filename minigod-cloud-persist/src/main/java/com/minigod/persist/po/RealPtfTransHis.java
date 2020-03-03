package com.minigod.persist.po;
import com.minigod.persist.tables.TRealPtfTransHis;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TRealPtfTransHis.class)
public class RealPtfTransHis implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer realPtfTransId;//交易编号
	private Integer userId;//用户ID
	private String clientReqId;
	private Integer ptfId;//组合ID
	private Integer brokerId;//券商ID
	private String brkCustid;
	private String transType;//交易类型
	private Date orderTime;//委托时间
	private Date orderTrd;//委托交易日
	private String comment;
	private String imGroupIds;//分享的群组列表
	private Integer ptfVersion;//组合版本号
	private String ptfOrderStatus;//委托总状态
	private String ptfSendStatus;//发送状态
	private String ptfFinishStatus;//结束状态
	private String ptfConfirmStatus;//成交状态
	private Date confirmTime;//成交时间
	private String ptfWithdrawStatus;//撤单状态
	private Date withdrawTime;//撤单时间
	private String orgTransId;
	private String ipAddress;
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getRealPtfTransId () {
        return realPtfTransId;
    }

    public void setRealPtfTransId (Integer realPtfTransId) {
        this.realPtfTransId = realPtfTransId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
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

    public String getTransType () {
        return transType;
    }

    public void setTransType (String transType) {
        this.transType = transType;
    }

    public Date getOrderTime () {
        return orderTime;
    }

    public void setOrderTime (Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderTrd () {
        return orderTrd;
    }

    public void setOrderTrd (Date orderTrd) {
        this.orderTrd = orderTrd;
    }

    public String getComment () {
        return comment;
    }

    public void setComment (String comment) {
        this.comment = comment;
    }

    public String getImGroupIds () {
        return imGroupIds;
    }

    public void setImGroupIds (String imGroupIds) {
        this.imGroupIds = imGroupIds;
    }

    public Integer getPtfVersion () {
        return ptfVersion;
    }

    public void setPtfVersion (Integer ptfVersion) {
        this.ptfVersion = ptfVersion;
    }

    public String getPtfOrderStatus () {
        return ptfOrderStatus;
    }

    public void setPtfOrderStatus (String ptfOrderStatus) {
        this.ptfOrderStatus = ptfOrderStatus;
    }

    public String getPtfSendStatus () {
        return ptfSendStatus;
    }

    public void setPtfSendStatus (String ptfSendStatus) {
        this.ptfSendStatus = ptfSendStatus;
    }

    public String getPtfFinishStatus () {
        return ptfFinishStatus;
    }

    public void setPtfFinishStatus (String ptfFinishStatus) {
        this.ptfFinishStatus = ptfFinishStatus;
    }

    public String getPtfConfirmStatus () {
        return ptfConfirmStatus;
    }

    public void setPtfConfirmStatus (String ptfConfirmStatus) {
        this.ptfConfirmStatus = ptfConfirmStatus;
    }

    public Date getConfirmTime () {
        return confirmTime;
    }

    public void setConfirmTime (Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getPtfWithdrawStatus () {
        return ptfWithdrawStatus;
    }

    public void setPtfWithdrawStatus (String ptfWithdrawStatus) {
        this.ptfWithdrawStatus = ptfWithdrawStatus;
    }

    public Date getWithdrawTime () {
        return withdrawTime;
    }

    public void setWithdrawTime (Date withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    public String getOrgTransId () {
        return orgTransId;
    }

    public void setOrgTransId (String orgTransId) {
        this.orgTransId = orgTransId;
    }

    public String getIpAddress () {
        return ipAddress;
    }

    public void setIpAddress (String ipAddress) {
        this.ipAddress = ipAddress;
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