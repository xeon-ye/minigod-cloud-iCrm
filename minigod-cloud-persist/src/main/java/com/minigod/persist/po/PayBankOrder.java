package com.minigod.persist.po;
import com.minigod.persist.tables.TPayBankOrder;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行卡支付订单
 */
@Entity(table=TPayBankOrder.class)
public class PayBankOrder implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer bankOrderId;//银行卡支付订单ID
	private String srcSys;//请求来源系统
	private String srcBus;//请求来源业务
	private String srcTransId;//客户端交易ID
	private String md5;//请求数据摘要
	private Integer accountId;//账户表ID
	private Integer userId;//犇犇用户id
	private String feeType;//货币类型
	private BigDecimal totalFee;//支付金额
	private String display = "Y";//是否在钱包中显示
	private String incomeOrExpense = "Y";//是否为收支项
	private String des;//订单描述
	private String detail;//订单详细描述
	private String finishStatus;//订单结束状态
	private String payStatus;//银行卡订单状态
	private String cbStatus;//回调状态
	private String actStatus;//是否已记账
	private Integer transactionId;//支付对应的交易请求表ID
	private BigDecimal frzAmt;//冻结的金额
	private BigDecimal refundAmt = new BigDecimal(0.00);//已申请退款金额
	private String mchId;//商户号
	private String billCreateIp;//终端IP
	private Date timeStart;//交易起始时间
	private Date timeExpire;//交易结束时间
	private String tradeType;//交易类型
	private String limitPay;//指定支付方式
	private String prepayId;//预支付交易会话标识
	private String bankErrMsg;//订单创建失败信息
	private String cbMethod;//回调的方法识别标志
	private String cbAttach;//附加信息
	private String cbRbReturn;//银行卡回调的传入完整信息
	private Integer cbTryTime;//尝试回调失败次数
	private String cbErrMsg;//回调的错误信息
	private String remark;//备注
	private Boolean isStatus;//记录状态
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getBankOrderId () {
        return bankOrderId;
    }

    public void setBankOrderId (Integer bankOrderId) {
        this.bankOrderId = bankOrderId;
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

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getFeeType () {
        return feeType;
    }

    public void setFeeType (String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getTotalFee () {
        return totalFee;
    }

    public void setTotalFee (BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getDisplay () {
        return display;
    }

    public void setDisplay (String display) {
        this.display = display;
    }

    public String getIncomeOrExpense () {
        return incomeOrExpense;
    }

    public void setIncomeOrExpense (String incomeOrExpense) {
        this.incomeOrExpense = incomeOrExpense;
    }

    public String getDes () {
        return des;
    }

    public void setDes (String des) {
        this.des = des;
    }

    public String getDetail () {
        return detail;
    }

    public void setDetail (String detail) {
        this.detail = detail;
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

    public String getActStatus () {
        return actStatus;
    }

    public void setActStatus (String actStatus) {
        this.actStatus = actStatus;
    }

    public Integer getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Integer transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getFrzAmt () {
        return frzAmt;
    }

    public void setFrzAmt (BigDecimal frzAmt) {
        this.frzAmt = frzAmt;
    }

    public BigDecimal getRefundAmt () {
        return refundAmt;
    }

    public void setRefundAmt (BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getMchId () {
        return mchId;
    }

    public void setMchId (String mchId) {
        this.mchId = mchId;
    }

    public String getBillCreateIp () {
        return billCreateIp;
    }

    public void setBillCreateIp (String billCreateIp) {
        this.billCreateIp = billCreateIp;
    }

    public Date getTimeStart () {
        return timeStart;
    }

    public void setTimeStart (Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeExpire () {
        return timeExpire;
    }

    public void setTimeExpire (Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getTradeType () {
        return tradeType;
    }

    public void setTradeType (String tradeType) {
        this.tradeType = tradeType;
    }

    public String getLimitPay () {
        return limitPay;
    }

    public void setLimitPay (String limitPay) {
        this.limitPay = limitPay;
    }

    public String getPrepayId () {
        return prepayId;
    }

    public void setPrepayId (String prepayId) {
        this.prepayId = prepayId;
    }

    public String getBankErrMsg () {
        return bankErrMsg;
    }

    public void setBankErrMsg (String bankErrMsg) {
        this.bankErrMsg = bankErrMsg;
    }

    public String getCbMethod () {
        return cbMethod;
    }

    public void setCbMethod (String cbMethod) {
        this.cbMethod = cbMethod;
    }

    public String getCbAttach () {
        return cbAttach;
    }

    public void setCbAttach (String cbAttach) {
        this.cbAttach = cbAttach;
    }

    public String getCbRbReturn () {
        return cbRbReturn;
    }

    public void setCbRbReturn (String cbRbReturn) {
        this.cbRbReturn = cbRbReturn;
    }

    public Integer getCbTryTime () {
        return cbTryTime;
    }

    public void setCbTryTime (Integer cbTryTime) {
        this.cbTryTime = cbTryTime;
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