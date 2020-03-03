package com.minigod.persist.po;
import com.minigod.persist.tables.TPayXfTransfer;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 先锋提现表
 */
@Entity(table=TPayXfTransfer.class)
public class PayXfTransfer implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer xfTransferId;//先锋转账表ID,主键，自增长字段
	private String srcSys;//请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS发送给微信服务器的客户订单号为32个字符，由src_sys,src_bus,c_trans_id组成。
	private String srcBus;//请求来源业务,齐牛内部业务系统功能登记到账务系统的代号
	private String srcTransId;//客户端交易ID,调用者传入的业务内不重复的字符串建议编码规则：yyyyMMddHHmmss+9位随机数。
	private String md5;//请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。
	private Integer userId;//提现的用户
	private BigDecimal amount;//提现金额
	private String sendStatus;//发送状态	A:客户申请提现，等待OMS批准,W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常),U:未知状态（不确定是否提现成功）,S:发送成功,E:失败。
	private String xfTradeNo;//先锋远程交易ID
	private Date tradeTime;//交易时间
	private Date callbackTime;//回调时间
	private String remoteStatus;//订单状态,成功S，失败F，处理中I
	private String xfErrMsg;//转账失败信息
	private Boolean isStatus;//记录状态,1-有效，0-无效（删除）
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getXfTransferId () {
        return xfTransferId;
    }

    public void setXfTransferId (Integer xfTransferId) {
        this.xfTransferId = xfTransferId;
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

    public String getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getXfTradeNo () {
        return xfTradeNo;
    }

    public void setXfTradeNo (String xfTradeNo) {
        this.xfTradeNo = xfTradeNo;
    }

    public Date getTradeTime () {
        return tradeTime;
    }

    public void setTradeTime (Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Date getCallbackTime () {
        return callbackTime;
    }

    public void setCallbackTime (Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public String getRemoteStatus () {
        return remoteStatus;
    }

    public void setRemoteStatus (String remoteStatus) {
        this.remoteStatus = remoteStatus;
    }

    public String getXfErrMsg () {
        return xfErrMsg;
    }

    public void setXfErrMsg (String xfErrMsg) {
        this.xfErrMsg = xfErrMsg;
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