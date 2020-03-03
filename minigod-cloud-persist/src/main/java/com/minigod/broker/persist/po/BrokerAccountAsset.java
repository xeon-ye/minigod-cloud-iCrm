package com.minigod.broker.persist.po;

import com.minigod.db4j.annotation.Entity;
import com.minigod.broker.persist.tables.TBrokerAccountAsset;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人客户帐户表
 */
@Entity(table=TBrokerAccountAsset.class)
public class BrokerAccountAsset implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long brokerId;//经理人ID
	private Date tradeDate;//交易日
	private BigDecimal addAccountAmount;//新增资产
	private BigDecimal accountAmount;//客户资产
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Long brokerId) {
        this.brokerId = brokerId;
    }

    public Date getTradeDate () {
        return tradeDate;
    }

    public void setTradeDate (Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getAddAccountAmount () {
        return addAccountAmount;
    }

    public void setAddAccountAmount (BigDecimal addAccountAmount) {
        this.addAccountAmount = addAccountAmount;
    }

    public BigDecimal getAccountAmount () {
        return accountAmount;
    }

    public void setAccountAmount (BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
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