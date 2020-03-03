package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerAccountCollocation;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人客户转仓信息表
 */
@Entity(table=TBrokerAccountCollocation.class)
public class BrokerAccountCollocation implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String tradeAccount;//交易账号
	private Integer userId;//犇犇号
	private String stockCode;//证券代码
	private String stockName;//证券名称
	private Date initDate;//转仓日期
	private Integer tradingVolume;//成交数量
	private BigDecimal tradingAmount;//成交金额
	private String tradingType;//转入转出类别
	private String currency;//货币名称
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
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

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Date getInitDate () {
        return initDate;
    }

    public void setInitDate (Date initDate) {
        this.initDate = initDate;
    }

    public Integer getTradingVolume () {
        return tradingVolume;
    }

    public void setTradingVolume (Integer tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public BigDecimal getTradingAmount () {
        return tradingAmount;
    }

    public void setTradingAmount (BigDecimal tradingAmount) {
        this.tradingAmount = tradingAmount;
    }

    public String getTradingType () {
        return tradingType;
    }

    public void setTradingType (String tradingType) {
        this.tradingType = tradingType;
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