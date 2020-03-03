package com.minigod.persist.po;
import com.minigod.persist.tables.TPayFzbOrder;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 富尊币支付订单
 */
@Entity(table=TPayFzbOrder.class)
public class PayFzbOrder implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer fzbOrderId;//富尊币支付订单ID
	private String srcSys;//请求来源系统
	private String srcBus;//请求来源业务
	private String srcTransId;//客户端交易ID
	private Integer accountId;//账户表ID
	private Integer userId;//用户id
	private String feeType;//货币类型
	private BigDecimal totalFee;//支付金额
	private BigDecimal frzAmt;//冻结的金额
	private BigDecimal refundAmt;//已申请退款金额
	private String display;//是否在钱包中显示
	private String incomeOrExpense;//是否为收支项
	private String des;//订单描述
	private Integer transactionId;//支付对应的交易请求表ID
	private String detail;//订单详细描述
	private String finishStatus;//订单结束状态
	private String actStatus;//是否已记账
	private String payStatus;//订单状态
	private String cbStatus;//回调状态
	private String cbErrMsg;//回调的错误信息
	private String remark;//备注
	private Boolean isStatus;//记录状态
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号
	private String md5;
	private String billCreateIp;
	private Date timeStart;
	private Date timeExpire;
	private String tradeType;
	private String cbMethod;
	private String cbAttach;

    public Integer getFzbOrderId () {
        return fzbOrderId;
    }

    public void setFzbOrderId (Integer fzbOrderId) {
        this.fzbOrderId = fzbOrderId;
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

    public Integer getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Integer transactionId) {
        this.transactionId = transactionId;
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

    public String getActStatus () {
        return actStatus;
    }

    public void setActStatus (String actStatus) {
        this.actStatus = actStatus;
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

    public String getMd5 () {
        return md5;
    }

    public void setMd5 (String md5) {
        this.md5 = md5;
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
}