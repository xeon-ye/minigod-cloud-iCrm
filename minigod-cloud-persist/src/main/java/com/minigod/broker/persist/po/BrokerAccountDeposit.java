package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerAccountDeposit;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人客户入金信息表
 */
@Entity(table=TBrokerAccountDeposit.class)
public class BrokerAccountDeposit implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Date initDate;//资金发生日期
	private String tradeAccount;//交易账号
	private Integer userId;//犇犇号
	private BigDecimal amount;//金额
	private String currency;//货币名称
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Date getInitDate () {
        return initDate;
    }

    public void setInitDate (Date initDate) {
        this.initDate = initDate;
    }

    public String getTradeAccount () {
        return tradeAccount;
    }

    public void setTradeAccount (String tradeAccount) {
        this.tradeAccount = tradeAccount;
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

    public String getCurrency () {
        return currency;
    }

    public void setCurrency (String currency) {
        this.currency = currency;
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