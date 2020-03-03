package com.minigod.persist.po;
import com.minigod.persist.tables.TPayXfRefund;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 先锋退款表
 */
@Entity(table=TPayXfRefund.class)
public class PayXfRefund implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer xfRefundId;//先锋退款订单ID,主键，自增长
	private String srcSys;//请求来源系统,齐牛内部业务系统登记到账务系统的代号
	private String srcBus;//请求来源业务,齐牛内部业务系统功能登记到账务系统的代号
	private String srcTransId;//客户端交易ID,调用者传入的业务内不重复的字符串
	private String md5;//请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等
	private String toRefundSys;//需要退款的订单所在系统
	private String toRefundBus;//需要退款的订单所属业务
	private String toRefundId;//需要退款的订单的交易Id
	private String tradeNo;//先锋订单号
	private BigDecimal orderAmt;//订单总金额,发送退款申请时要用到
	private BigDecimal refundAmt;//退款金额
	private String description;//订单描述,商品或者支付的简要描述
	private String sendStatus;//请求发送状态,A:客户申请提现，等待OMS批准W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常)U:未知状态（不确定是否提现成功）E:失败。S:发送成功
	private String refundStatus;//退款状态,处理中I成功S失败F
	private String remark;//备注信息
	private Boolean isStatus;//记录状态,1-有效，0-无效（删除）
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getXfRefundId () {
        return xfRefundId;
    }

    public void setXfRefundId (Integer xfRefundId) {
        this.xfRefundId = xfRefundId;
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

    public String getTradeNo () {
        return tradeNo;
    }

    public void setTradeNo (String tradeNo) {
        this.tradeNo = tradeNo;
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

    public String getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getRefundStatus () {
        return refundStatus;
    }

    public void setRefundStatus (String refundStatus) {
        this.refundStatus = refundStatus;
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