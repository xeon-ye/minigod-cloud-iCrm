package com.minigod.persist.po;
import com.minigod.persist.tables.TPayXfOrder;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 先锋支付订单表
 */
@Entity(table=TPayXfOrder.class)
public class PayXfOrder implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer xfOrderId;//先锋支付订单ID,主键，自增长
	private String srcSys;//请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS
	private String srcBus;//请求来源业务,齐牛内部业务系统功能登记到账务系统的代号
	private String srcTransId;//客户端交易ID,调用者传入的业务内不重复的字符串
	private String md5;//请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。
	private Integer userId;//关联的齐牛账户号
	private BigDecimal totalFee;//,支付金额,我们定义的最小额度为厘,后一位小数，微信支付最小的支付额度为分。
	private String description;//订单描述,商品或者支付的简要描述
	private String finishStatus;//订单结束状态Y:结束N:未结束E：异常(异常数据不进行后续处理，等待人工干预)
	private String payStatus;//订单状态U:订单等待创建F:订单创建失败W:等待付款S:已付款
	private String cbStatus;//回调状态A:等待支付W:等待回调S:回调成功会有单独的线程扫描本表中回调状态为W的记录，并进行回调操作。
	private String xfTradeNo;//先锋交易流水号,创建订单时返回
	private Date callbackTime;//回调接收的时间
	private String bankCardNo;//用户绑定卡号
	private String bankId;//绑定银行
	private String bankName;//银行名称
	private String xfOrderStatus;//远程支付状态,等待支付W,成功S,失败E
	private Date xfPayTime;//先锋支付时间
	private Integer xfCbRespId;//先锋回调的传入参数
	private String xfCbMd5;//先锋回调数据摘要
	private String authStatus;//认证绑卡结果“00”成功，其他失败
	private Integer checkCount = 0;//已检测支付次数
	private Date checkTime;//检测的时间
	private String cbMethod;//回调的方法识别标志当回调状态为P/W/S时，必须有值
	private String cbErrMsg;//回调的错误信息
	private String remark;//备注信息
	private Boolean isStatus;//记录状态1-有效，0-无效（删除）
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getXfOrderId () {
        return xfOrderId;
    }

    public void setXfOrderId (Integer xfOrderId) {
        this.xfOrderId = xfOrderId;
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

    public BigDecimal getTotalFee () {
        return totalFee;
    }

    public void setTotalFee (BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getFinishStatus () {
        return finishStatus;
    }

    public void setFinishStatus (String finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getPayStatus () {
        return payStatus;
    }

    public void setPayStatus (String payStatus) {
        this.payStatus = payStatus;
    }

    public String getCbStatus () {
        return cbStatus;
    }

    public void setCbStatus (String cbStatus) {
        this.cbStatus = cbStatus;
    }

    public String getXfTradeNo () {
        return xfTradeNo;
    }

    public void setXfTradeNo (String xfTradeNo) {
        this.xfTradeNo = xfTradeNo;
    }

    public Date getCallbackTime () {
        return callbackTime;
    }

    public void setCallbackTime (Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public String getBankCardNo () {
        return bankCardNo;
    }

    public void setBankCardNo (String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankId () {
        return bankId;
    }

    public void setBankId (String bankId) {
        this.bankId = bankId;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public String getXfOrderStatus () {
        return xfOrderStatus;
    }

    public void setXfOrderStatus (String xfOrderStatus) {
        this.xfOrderStatus = xfOrderStatus;
    }

    public Date getXfPayTime () {
        return xfPayTime;
    }

    public void setXfPayTime (Date xfPayTime) {
        this.xfPayTime = xfPayTime;
    }

    public Integer getXfCbRespId () {
        return xfCbRespId;
    }

    public void setXfCbRespId (Integer xfCbRespId) {
        this.xfCbRespId = xfCbRespId;
    }

    public String getXfCbMd5 () {
        return xfCbMd5;
    }

    public void setXfCbMd5 (String xfCbMd5) {
        this.xfCbMd5 = xfCbMd5;
    }

    public String getAuthStatus () {
        return authStatus;
    }

    public void setAuthStatus (String authStatus) {
        this.authStatus = authStatus;
    }

    public Integer getCheckCount () {
        return checkCount;
    }

    public void setCheckCount (Integer checkCount) {
        this.checkCount = checkCount;
    }

    public Date getCheckTime () {
        return checkTime;
    }

    public void setCheckTime (Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCbMethod () {
        return cbMethod;
    }

    public void setCbMethod (String cbMethod) {
        this.cbMethod = cbMethod;
    }

    public String getCbErrMsg () {
        return cbErrMsg;
    }

    public void setCbErrMsg (String cbErrMsg) {
        this.cbErrMsg = cbErrMsg;
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