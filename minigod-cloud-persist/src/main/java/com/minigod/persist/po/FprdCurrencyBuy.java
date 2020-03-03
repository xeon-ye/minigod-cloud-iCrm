package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdCurrencyBuy;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 先锋支付订单表
 */
@Entity(table=TFprdCurrencyBuy.class)
public class FprdCurrencyBuy implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer currencyBuyId;//订单ID 自增长字段，主键
	private Integer userId;//订单委托用户ID
	private BigDecimal amount;//订单金额
	private String orderLifeCycle;//订单生命周期
	private String buyStatus;//申购结果 I:申购中S:申购成功F:申购失败P:部分申购成功
	private String buyFailedMsg;//申购失败信息
	private String xfPayLocalId;//支付请求ID,与先锋支付模块对接的字段,本字段创建记录时创建，并不再变更
	private String xfPayRemoteId;//先锋交易订单ID
	private String xfPayStatus;//付款状态,Y/N,默认为N,付款回调后改为Y,红豆接口调用（红豆代扣及购买）
	private String hdLocalId;//红豆本地请求ID,本字段由付款后填入,本字段有值表示客户已经付款了,本字段一旦生成，不能再变更
	private String hdRemoteId;//红豆交易ID,由红豆返回。
	private String hdSendStatus;//订单发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功
	private String hdErrorMsg;//调用返回的错误描述
	private Integer hdLocalOrderStatus;//本地订单状态,1订单成功,2订单操作中,3订单部分成功,4订单失败,将存在后台进程扫描订单状态为null或者2的订单。扫描时间需要根据2秒为基数翻倍，5分钟封顶。
	private String hdRemoteOrderStatus;//远程订单状态
	private BigDecimal hdSucceedAmount;//订单成功金额,红豆理财订单不一定成功，或者会部分成功，剩余部分需要退款。
	private Date syncTime;//数据同步时间
	private Integer syncIntervel;//下次数据同步的时间间隔（秒）
	private Date syncNextTime;//下次开始同步的时间
	private String xfRefundLocalId;//退款请求ID,与先锋支付模块对接的字段,当本字段有值时表示需要退款,本字段有值表示需要退款,本字段一旦生成，不能再变更
	private String xfRefundRemoteId;//先锋退款远程ID
	private String xfRefundSendStatus;//退款请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功
	private String xfRefundError;//退款失败的错误信息
	private String xfRefundOrderStatus;//退款状态 成功S，失败F，处理中I
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCurrencyBuyId () {
        return currencyBuyId;
    }

    public void setCurrencyBuyId (Integer currencyBuyId) {
        this.currencyBuyId = currencyBuyId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderLifeCycle () {
        return orderLifeCycle;
    }

    public void setOrderLifeCycle (String orderLifeCycle) {
        this.orderLifeCycle = orderLifeCycle;
    }

    public String getBuyStatus () {
        return buyStatus;
    }

    public void setBuyStatus (String buyStatus) {
        this.buyStatus = buyStatus;
    }

    public String getBuyFailedMsg () {
        return buyFailedMsg;
    }

    public void setBuyFailedMsg (String buyFailedMsg) {
        this.buyFailedMsg = buyFailedMsg;
    }

    public String getXfPayLocalId () {
        return xfPayLocalId;
    }

    public void setXfPayLocalId (String xfPayLocalId) {
        this.xfPayLocalId = xfPayLocalId;
    }

    public String getXfPayRemoteId () {
        return xfPayRemoteId;
    }

    public void setXfPayRemoteId (String xfPayRemoteId) {
        this.xfPayRemoteId = xfPayRemoteId;
    }

    public String getXfPayStatus () {
        return xfPayStatus;
    }

    public void setXfPayStatus (String xfPayStatus) {
        this.xfPayStatus = xfPayStatus;
    }

    public String getHdLocalId () {
        return hdLocalId;
    }

    public void setHdLocalId (String hdLocalId) {
        this.hdLocalId = hdLocalId;
    }

    public String getHdRemoteId () {
        return hdRemoteId;
    }

    public void setHdRemoteId (String hdRemoteId) {
        this.hdRemoteId = hdRemoteId;
    }

    public String getHdSendStatus () {
        return hdSendStatus;
    }

    public void setHdSendStatus (String hdSendStatus) {
        this.hdSendStatus = hdSendStatus;
    }

    public String getHdErrorMsg () {
        return hdErrorMsg;
    }

    public void setHdErrorMsg (String hdErrorMsg) {
        this.hdErrorMsg = hdErrorMsg;
    }

    public Integer getHdLocalOrderStatus () {
        return hdLocalOrderStatus;
    }

    public void setHdLocalOrderStatus (Integer hdLocalOrderStatus) {
        this.hdLocalOrderStatus = hdLocalOrderStatus;
    }

    public String getHdRemoteOrderStatus () {
        return hdRemoteOrderStatus;
    }

    public void setHdRemoteOrderStatus (String hdRemoteOrderStatus) {
        this.hdRemoteOrderStatus = hdRemoteOrderStatus;
    }

    public BigDecimal getHdSucceedAmount () {
        return hdSucceedAmount;
    }

    public void setHdSucceedAmount (BigDecimal hdSucceedAmount) {
        this.hdSucceedAmount = hdSucceedAmount;
    }

    public Date getSyncTime () {
        return syncTime;
    }

    public void setSyncTime (Date syncTime) {
        this.syncTime = syncTime;
    }

    public Integer getSyncIntervel () {
        return syncIntervel;
    }

    public void setSyncIntervel (Integer syncIntervel) {
        this.syncIntervel = syncIntervel;
    }

    public Date getSyncNextTime () {
        return syncNextTime;
    }

    public void setSyncNextTime (Date syncNextTime) {
        this.syncNextTime = syncNextTime;
    }

    public String getXfRefundLocalId () {
        return xfRefundLocalId;
    }

    public void setXfRefundLocalId (String xfRefundLocalId) {
        this.xfRefundLocalId = xfRefundLocalId;
    }

    public String getXfRefundRemoteId () {
        return xfRefundRemoteId;
    }

    public void setXfRefundRemoteId (String xfRefundRemoteId) {
        this.xfRefundRemoteId = xfRefundRemoteId;
    }

    public String getXfRefundSendStatus () {
        return xfRefundSendStatus;
    }

    public void setXfRefundSendStatus (String xfRefundSendStatus) {
        this.xfRefundSendStatus = xfRefundSendStatus;
    }

    public String getXfRefundError () {
        return xfRefundError;
    }

    public void setXfRefundError (String xfRefundError) {
        this.xfRefundError = xfRefundError;
    }

    public String getXfRefundOrderStatus () {
        return xfRefundOrderStatus;
    }

    public void setXfRefundOrderStatus (String xfRefundOrderStatus) {
        this.xfRefundOrderStatus = xfRefundOrderStatus;
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