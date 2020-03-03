package com.minigod.persist.po;
import com.minigod.persist.tables.TPayBankTransfer;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行卡提现
 */
@Entity(table=TPayBankTransfer.class)
public class PayBankTransfer implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer bankTransferId;//银行卡转账表ID
	private String bankCellPhone;//银行预留手机号
	private String bankNo;//银行卡号
	private String bankName;//银行名称
	private String srcSys;//请求来源系统
	private String srcBus;//请求来源业务
	private String srcTransId;//客户端交易ID
	private String md5;//请求数据摘要
	private String clientReqId;//客户端请求ID
	private Integer accountId;//业务中的转出账号
	private BigDecimal totalFee;//转账金额
	private BigDecimal poundage;//收取的手续费
	private BigDecimal unFrzAmt;//解冻金额
	private Integer unFrzRelaTrx;//解冻关联的交易
	private String sendStatus;//发送状态
	private Integer transactionId;//支付对应的交易请求表ID
	private Integer rvsTrxId;//冲账交易的交易请求表ID
	private String display = "Y";//是否在钱包中显示
	private String incomeOrExpense = "Y";//是否为收支项
	private String description;//提现描述
	private String checkName;//是否校验真实姓名
	private String reName;//客户真实姓名
	private String mchId;//商户号
	private String bankErrMsg;//转账失败信息
	private Boolean isStatus;//记录状态
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getBankTransferId () {
        return bankTransferId;
    }

    public void setBankTransferId (Integer bankTransferId) {
        this.bankTransferId = bankTransferId;
    }

    public String getBankCellPhone () {
        return bankCellPhone;
    }

    public void setBankCellPhone (String bankCellPhone) {
        this.bankCellPhone = bankCellPhone;
    }

    public String getBankNo () {
        return bankNo;
    }

    public void setBankNo (String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
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

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getTotalFee () {
        return totalFee;
    }

    public void setTotalFee (BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getPoundage () {
        return poundage;
    }

    public void setPoundage (BigDecimal poundage) {
        this.poundage = poundage;
    }

    public BigDecimal getUnFrzAmt () {
        return unFrzAmt;
    }

    public void setUnFrzAmt (BigDecimal unFrzAmt) {
        this.unFrzAmt = unFrzAmt;
    }

    public Integer getUnFrzRelaTrx () {
        return unFrzRelaTrx;
    }

    public void setUnFrzRelaTrx (Integer unFrzRelaTrx) {
        this.unFrzRelaTrx = unFrzRelaTrx;
    }

    public String getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getRvsTrxId () {
        return rvsTrxId;
    }

    public void setRvsTrxId (Integer rvsTrxId) {
        this.rvsTrxId = rvsTrxId;
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

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getCheckName () {
        return checkName;
    }

    public void setCheckName (String checkName) {
        this.checkName = checkName;
    }

    public String getReName () {
        return reName;
    }

    public void setReName (String reName) {
        this.reName = reName;
    }

    public String getMchId () {
        return mchId;
    }

    public void setMchId (String mchId) {
        this.mchId = mchId;
    }

    public String getBankErrMsg () {
        return bankErrMsg;
    }

    public void setBankErrMsg (String bankErrMsg) {
        this.bankErrMsg = bankErrMsg;
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