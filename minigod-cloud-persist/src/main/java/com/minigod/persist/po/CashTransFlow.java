package com.minigod.persist.po;
import com.minigod.persist.tables.TCashTransFlow;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TCashTransFlow.class)
public class CashTransFlow implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer flowId;//交易流水id
	private Integer transactionId;//交易请求表ID
	private Integer accountId;//账户ID
	private Date accountDate;//记账日期
	private Integer accountSeq;//账户日内流水号
	private String direction;//记账方向
	private BigDecimal amount;//本次交易金额
	private BigDecimal frzAmount;//本次冻结金额
	private BigDecimal balance;//交易后账户余额
	private BigDecimal frzBalance;//交易后冻结余额
	private Integer unfrzRelTrx;//解冻对应的冻结事务Id
	private String display = "Y";//是否在钱包中显示
	private String incomeOrExpense = "Y";//是否为收支项
	private String actTitle;//记账标题
	private String actDesc;//对本次记账的简要描述
	private Date accountTime;//记账时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getFlowId () {
        return flowId;
    }

    public void setFlowId (Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public Date getAccountDate () {
        return accountDate;
    }

    public void setAccountDate (Date accountDate) {
        this.accountDate = accountDate;
    }

    public Integer getAccountSeq () {
        return accountSeq;
    }

    public void setAccountSeq (Integer accountSeq) {
        this.accountSeq = accountSeq;
    }

    public String getDirection () {
        return direction;
    }

    public void setDirection (String direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrzAmount () {
        return frzAmount;
    }

    public void setFrzAmount (BigDecimal frzAmount) {
        this.frzAmount = frzAmount;
    }

    public BigDecimal getBalance () {
        return balance;
    }

    public void setBalance (BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrzBalance () {
        return frzBalance;
    }

    public void setFrzBalance (BigDecimal frzBalance) {
        this.frzBalance = frzBalance;
    }

    public Integer getUnfrzRelTrx () {
        return unfrzRelTrx;
    }

    public void setUnfrzRelTrx (Integer unfrzRelTrx) {
        this.unfrzRelTrx = unfrzRelTrx;
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

    public String getActTitle () {
        return actTitle;
    }

    public void setActTitle (String actTitle) {
        this.actTitle = actTitle;
    }

    public String getActDesc () {
        return actDesc;
    }

    public void setActDesc (String actDesc) {
        this.actDesc = actDesc;
    }

    public Date getAccountTime () {
        return accountTime;
    }

    public void setAccountTime (Date accountTime) {
        this.accountTime = accountTime;
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