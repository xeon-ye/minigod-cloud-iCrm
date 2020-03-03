package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerCashAcc;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人帐户表
 */
@Entity(table=TBrokerCashAcc.class)
public class BrokerCashAcc implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long accountId;//账户ID
	private Long brokerId;//关联账户
	private String accName;//账户名称及描述
	private String ccy;//币种
	private BigDecimal balance = new BigDecimal(0.00);//扣除风险金和提现后的账户余额
	private BigDecimal addBalance = new BigDecimal(0.00);//新增收益
	private BigDecimal addRiskBalance = new BigDecimal(0.00);//新增收益的风险金
	private BigDecimal riskBalance = new BigDecimal(0.00);//风险金,收取新增收益的10%
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Boolean isWith = false;//是否可提现

    public Long getAccountId () {
        return accountId;
    }

    public void setAccountId (Long accountId) {
        this.accountId = accountId;
    }

    public Long getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getAccName () {
        return accName;
    }

    public void setAccName (String accName) {
        this.accName = accName;
    }

    public String getCcy () {
        return ccy;
    }

    public void setCcy (String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getBalance () {
        return balance;
    }

    public void setBalance (BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAddBalance () {
        return addBalance;
    }

    public void setAddBalance (BigDecimal addBalance) {
        this.addBalance = addBalance;
    }

    public BigDecimal getAddRiskBalance () {
        return addRiskBalance;
    }

    public void setAddRiskBalance (BigDecimal addRiskBalance) {
        this.addRiskBalance = addRiskBalance;
    }

    public BigDecimal getRiskBalance () {
        return riskBalance;
    }

    public void setRiskBalance (BigDecimal riskBalance) {
        this.riskBalance = riskBalance;
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

    public Boolean getIsWith () {
        return isWith;
    }

    public void setIsWith (Boolean isWith) {
        this.isWith = isWith;
    }
}