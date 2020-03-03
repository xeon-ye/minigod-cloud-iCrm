package com.minigod.persist.po;
import com.minigod.persist.tables.THqLogInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqLogInfo.class)
public class HqLogInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long logId;
	private Long relationId;//关联ID
	private String userName;
	private Long userId;//用户ID
	private String loginFrom;//来源平台
	private String loginIp;//来源ip
	private String loginAdr;//地区
	private String opDesc;//描述
	private Date opTime;//记录时间
	private String stockName;//股票名称
	private String stockCode;//股票代码
	private Long packageId;
	private String exchange;//美股交易市场

    public Long getLogId () {
        return logId;
    }

    public void setLogId (Long logId) {
        this.logId = logId;
    }

    public Long getRelationId () {
        return relationId;
    }

    public void setRelationId (Long relationId) {
        this.relationId = relationId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getLoginFrom () {
        return loginFrom;
    }

    public void setLoginFrom (String loginFrom) {
        this.loginFrom = loginFrom;
    }

    public String getLoginIp () {
        return loginIp;
    }

    public void setLoginIp (String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAdr () {
        return loginAdr;
    }

    public void setLoginAdr (String loginAdr) {
        this.loginAdr = loginAdr;
    }

    public String getOpDesc () {
        return opDesc;
    }

    public void setOpDesc (String opDesc) {
        this.opDesc = opDesc;
    }

    public Date getOpTime () {
        return opTime;
    }

    public void setOpTime (Date opTime) {
        this.opTime = opTime;
    }

    public String getStockName () {
        return stockName;
    }

    public void setStockName (String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode () {
        return stockCode;
    }

    public void setStockCode (String stockCode) {
        this.stockCode = stockCode;
    }

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public String getExchange () {
        return exchange;
    }

    public void setExchange (String exchange) {
        this.exchange = exchange;
    }
}