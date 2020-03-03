package com.minigod.persist.po;
import com.minigod.persist.tables.TUserCommission;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserCommission.class)
public class UserCommission implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;
	private String fundAccount;
	private String clientId;
	private String fareDict;
	private String feeType;
	private String feeCount;
	private String fareType;
	private String exchangeType;
	private String stockType;
	private String stockCode;
	private String entrustBs;
	private String entrustWay;
	private String moneyType;
	private String minFare;
	private String maxFare;
	private String precisions;
	private String precisionFlag;
	private String feeCountFix;
	private String fareStr;
	private String beginDate;
	private String endDate;
	private Date createTime;
	private Date updateTime;
	private Integer status = 0;//0 生效 1 失效

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getFareDict () {
        return fareDict;
    }

    public void setFareDict (String fareDict) {
        this.fareDict = fareDict;
    }

    public String getFeeType () {
        return feeType;
    }

    public void setFeeType (String feeType) {
        this.feeType = feeType;
    }

    public String getFareType () {
        return fareType;
    }

    public void setFareType (String fareType) {
        this.fareType = fareType;
    }

    public String getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getStockType () {
        return stockType;
    }

    public void setStockType (String stockType) {
        this.stockType = stockType;
    }

    public String getStockCode () {
        return stockCode;
    }

    public void setStockCode (String stockCode) {
        this.stockCode = stockCode;
    }

    public String getEntrustBs () {
        return entrustBs;
    }

    public void setEntrustBs (String entrustBs) {
        this.entrustBs = entrustBs;
    }

    public String getEntrustWay () {
        return entrustWay;
    }

    public void setEntrustWay (String entrustWay) {
        this.entrustWay = entrustWay;
    }

    public String getMoneyType () {
        return moneyType;
    }

    public void setMoneyType (String moneyType) {
        this.moneyType = moneyType;
    }

    public String getMinFare () {
        return minFare;
    }

    public void setMinFare (String minFare) {
        this.minFare = minFare;
    }

    public String getMaxFare () {
        return maxFare;
    }

    public void setMaxFare (String maxFare) {
        this.maxFare = maxFare;
    }

    public String getPrecisions () {
        return precisions;
    }

    public void setPrecisions (String precisions) {
        this.precisions = precisions;
    }

    public String getPrecisionFlag () {
        return precisionFlag;
    }

    public void setPrecisionFlag (String precisionFlag) {
        this.precisionFlag = precisionFlag;
    }

    public String getFeeCountFix () {
        return feeCountFix;
    }

    public void setFeeCountFix (String feeCountFix) {
        this.feeCountFix = feeCountFix;
    }

    public String getFareStr () {
        return fareStr;
    }

    public void setFareStr (String fareStr) {
        this.fareStr = fareStr;
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

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }
    
    public String getBeginDate () {
        return beginDate;
    }

    public void setBeginDate (String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate () {
        return endDate;
    }

    public void setEndDate (String endDate) {
        this.endDate = endDate;
    }
	public String getFeeCount() {
		return feeCount;
	}

	public void setFeeCount(String feeCount) {
		this.feeCount = feeCount;
	}
}