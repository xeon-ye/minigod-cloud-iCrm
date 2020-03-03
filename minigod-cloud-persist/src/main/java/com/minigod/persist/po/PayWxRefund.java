package com.minigod.persist.po;
import com.minigod.persist.tables.TPayWxRefund;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPayWxRefund.class)
public class PayWxRefund implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer wxRefundId;//微信退款订单ID
	private String srcSys;//请求来源系统
	private String srcBus;//请求来源业务
	private String srcTransId;//客户端交易ID
	private String md5;//请求数据摘要
	private Integer accountId;//执行退款的账号
	private String toRefundSys;//需要退款的订单所在系统
	private String toRefundBus;//需要退款的订单所属业务
	private String toRefundId;//需要退款的订单的交易Id
	private BigDecimal orderAmt;//订单总金额
	private BigDecimal refundAmt;//退款金额
	private String description;//订单描述
	private String refundChannel;//退款渠道
	private String refundStatus;//退款状态
	private Date refundSentTime;//退款申请发送时间
	private Integer frzTrxId;//冻结退款的交易ID
	private Integer refundTrxId;//确认微信退款后的交易ID
	private String appid;//公众账号ID
	private String mchId;//商户号
	private String remark;//备注信息
	private Boolean isStatus;//记录状态
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getWxRefundId () {
        return wxRefundId;
    }

    public void setWxRefundId (Integer wxRefundId) {
        this.wxRefundId = wxRefundId;
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

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public String getToRefundSys () {
        return toRefundSys;
    }

    public void setToRefundSys (String toRefundSys) {
        this.toRefundSys = toRefundSys;
    }

    public String getToRefundBus () {
        return toRefundBus;
    }

    public void setToRefundBus (String toRefundBus) {
        this.toRefundBus = toRefundBus;
    }

    public String getToRefundId () {
        return toRefundId;
    }

    public void setToRefundId (String toRefundId) {
        this.toRefundId = toRefundId;
    }

    public BigDecimal getOrderAmt () {
        return orderAmt;
    }

    public void setOrderAmt (BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public BigDecimal getRefundAmt () {
        return refundAmt;
    }

    public void setRefundAmt (BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getRefundChannel () {
        return refundChannel;
    }

    public void setRefundChannel (String refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundStatus () {
        return refundStatus;
    }

    public void setRefundStatus (String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundSentTime () {
        return refundSentTime;
    }

    public void setRefundSentTime (Date refundSentTime) {
        this.refundSentTime = refundSentTime;
    }

    public Integer getFrzTrxId () {
        return frzTrxId;
    }

    public void setFrzTrxId (Integer frzTrxId) {
        this.frzTrxId = frzTrxId;
    }

    public Integer getRefundTrxId () {
        return refundTrxId;
    }

    public void setRefundTrxId (Integer refundTrxId) {
        this.refundTrxId = refundTrxId;
    }

    public String getAppid () {
        return appid;
    }

    public void setAppid (String appid) {
        this.appid = appid;
    }

    public String getMchId () {
        return mchId;
    }

    public void setMchId (String mchId) {
        this.mchId = mchId;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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