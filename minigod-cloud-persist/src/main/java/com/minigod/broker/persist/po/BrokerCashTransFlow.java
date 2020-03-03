package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerCashTransFlow;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人帐户流水表
 */
@Entity(table=TBrokerCashTransFlow.class)
public class BrokerCashTransFlow implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long flowId;//交易流水ID
	private Long accountId;//账户ID
	private String subjectId;//科目ID
	private Date accountDate;//记账日期
	private Integer incomeType;//收入类型 0:收入 1:提现
	private Integer withStatus = 0;//提现状态
	private BigDecimal amount = new BigDecimal(0.00);//本次交易金额(扣除风险金)
	private BigDecimal frzAmount = new BigDecimal(0.00);//本次冻结金额
	private BigDecimal riskBalance = new BigDecimal(0.00);//风险金
	private String actTitle;//记账标题
	private String actDesc;//对本次记账的简要描述
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getFlowId () {
        return flowId;
    }

    public void setFlowId (Long flowId) {
        this.flowId = flowId;
    }

    public Long getAccountId () {
        return accountId;
    }

    public void setAccountId (Long accountId) {
        this.accountId = accountId;
    }

    public String getSubjectId () {
        return subjectId;
    }

    public void setSubjectId (String subjectId) {
        this.subjectId = subjectId;
    }

    public Date getAccountDate () {
        return accountDate;
    }

    public void setAccountDate (Date accountDate) {
        this.accountDate = accountDate;
    }

    public Integer getIncomeType () {
        return incomeType;
    }

    public void setIncomeType (Integer incomeType) {
        this.incomeType = incomeType;
    }

    public Integer getWithStatus () {
        return withStatus;
    }

    public void setWithStatus (Integer withStatus) {
        this.withStatus = withStatus;
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

    public BigDecimal getRiskBalance () {
        return riskBalance;
    }

    public void setRiskBalance (BigDecimal riskBalance) {
        this.riskBalance = riskBalance;
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
}