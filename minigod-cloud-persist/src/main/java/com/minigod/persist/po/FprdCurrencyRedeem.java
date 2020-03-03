package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdCurrencyRedeem;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财活期赎回订单表
 */
@Entity(table=TFprdCurrencyRedeem.class)
public class FprdCurrencyRedeem implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer currencyRedeemId;//订单ID	自增长字段，主键
	private Integer userId;//订单委托用户ID	
	private String clientReqId;//客户端请求ID
	private String md5;//请求数据摘要
	private BigDecimal amount;//申请赎回金额	
	private String free;//占用免费提现机会,Y/N
	private BigDecimal redeemFee;//提现手续费	
	private String orderLifeCycle;//订单生命周期,A等待调用红豆接口B红豆接口调用完毕，轮询红豆订单处理状态C红豆订单处理完毕，等待调用先锋代发接口D调用先锋代发接口完毕，等待所有的先锋回调告知最终处理结果F （获得最终处理结果）订单结束
	private String redeemStatus;//赎回状态,I:赎回中S:赎回成功F:赎回失败P:部分赎回成功
	private String redeemFailedMsg;//赎回失败信息
	private String hdLocalId;//红豆本地请求ID,创建订单后马上生成
	private String hdRemoteId;//红豆交易ID,由红豆返回。
	private String hdSendStatus;//订单发送状态,W:等待发送E:发生了明确错误U:未知状态（无回应或者发生了异常）S:成功
	private String hdErrorMsg;//调用返回的错误描述	
	private Integer hdLocalOrderStatus;//本地订单状态1 订单成功（钱已到 先锋齐牛商户号）2 订单操作中 3订单部分成功4订单失败
	private String hdRemoteOrderStatus;//远程订单状态
	private BigDecimal hdSucceedAmount;//赎回成功金额,红豆理财订单不一定成功，或者会部分成功，这时候需要退款。提现的金额与赎回成功的金额一致。
	private Date syncTime;
	private Integer syncIntervel;//下次同步的时间间隔（秒）
	private Date syncNextTime;//下次开始同步的时间
	private String xfWithdrawId;//提现请求ID,与先锋支付模块对接的字段,本字段一旦生成，不能再变更
	private String xfSendStatus;//提现请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功
	private String xfSendError;//提现调用失败的错误信息	
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCurrencyRedeemId () {
        return currencyRedeemId;
    }

    public void setCurrencyRedeemId (Integer currencyRedeemId) {
        this.currencyRedeemId = currencyRedeemId;
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

    public String getMd5 () {
        return md5;
    }

    public void setMd5 (String md5) {
        this.md5 = md5;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public String getFree () {
        return free;
    }

    public void setFree (String free) {
        this.free = free;
    }

    public BigDecimal getRedeemFee () {
        return redeemFee;
    }

    public void setRedeemFee (BigDecimal redeemFee) {
        this.redeemFee = redeemFee;
    }

    public String getOrderLifeCycle () {
        return orderLifeCycle;
    }

    public void setOrderLifeCycle (String orderLifeCycle) {
        this.orderLifeCycle = orderLifeCycle;
    }

    public String getRedeemStatus () {
        return redeemStatus;
    }

    public void setRedeemStatus (String redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public String getRedeemFailedMsg () {
        return redeemFailedMsg;
    }

    public void setRedeemFailedMsg (String redeemFailedMsg) {
        this.redeemFailedMsg = redeemFailedMsg;
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

    public String getXfWithdrawId () {
        return xfWithdrawId;
    }

    public void setXfWithdrawId (String xfWithdrawId) {
        this.xfWithdrawId = xfWithdrawId;
    }

    public String getXfSendStatus () {
        return xfSendStatus;
    }

    public void setXfSendStatus (String xfSendStatus) {
        this.xfSendStatus = xfSendStatus;
    }

    public String getXfSendError () {
        return xfSendError;
    }

    public void setXfSendError (String xfSendError) {
        this.xfSendError = xfSendError;
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