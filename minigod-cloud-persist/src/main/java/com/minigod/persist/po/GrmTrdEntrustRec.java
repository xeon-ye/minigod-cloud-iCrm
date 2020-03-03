package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmTrdEntrustRec;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmTrdEntrustRec.class)
public class GrmTrdEntrustRec implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long jourId;
	private Date initDate;
	private Integer entrustNo;
	private Date currDate;
	private String clientId;
	private String market;
	private String assetId;
	private String entrustBs;
	private Double entrustAmount;
	private Double entrustPrice;
	private String entrustType;
	private Double businessAmount;
	private Double businessBalanceHkd;
	private Double businessBalance;
	private Double clearBalance;
	private String moneyType;
	private String entrustStatus;
	private String extPositionStr;
	private String remark;
	private String code;
	private Integer fundAccount;

    public Long getJourId () {
        return jourId;
    }

    public void setJourId (Long jourId) {
        this.jourId = jourId;
    }

    public Date getInitDate () {
        return initDate;
    }

    public void setInitDate (Date initDate) {
        this.initDate = initDate;
    }

    public Integer getEntrustNo () {
        return entrustNo;
    }

    public void setEntrustNo (Integer entrustNo) {
        this.entrustNo = entrustNo;
    }

    public Date getCurrDate () {
        return currDate;
    }

    public void setCurrDate (Date currDate) {
        this.currDate = currDate;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getMarket () {
        return market;
    }

    public void setMarket (String market) {
        this.market = market;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public String getEntrustBs () {
        return entrustBs;
    }

    public void setEntrustBs (String entrustBs) {
        this.entrustBs = entrustBs;
    }

    public Double getEntrustAmount () {
        return entrustAmount;
    }

    public void setEntrustAmount (Double entrustAmount) {
        this.entrustAmount = entrustAmount;
    }

    public Double getEntrustPrice () {
        return entrustPrice;
    }

    public void setEntrustPrice (Double entrustPrice) {
        this.entrustPrice = entrustPrice;
    }

    public String getEntrustType () {
        return entrustType;
    }

    public void setEntrustType (String entrustType) {
        this.entrustType = entrustType;
    }

    public Double getBusinessAmount () {
        return businessAmount;
    }

    public void setBusinessAmount (Double businessAmount) {
        this.businessAmount = businessAmount;
    }

    public Double getBusinessBalanceHkd () {
        return businessBalanceHkd;
    }

    public void setBusinessBalanceHkd (Double businessBalanceHkd) {
        this.businessBalanceHkd = businessBalanceHkd;
    }

    public Double getBusinessBalance () {
        return businessBalance;
    }

    public void setBusinessBalance (Double businessBalance) {
        this.businessBalance = businessBalance;
    }

    public Double getClearBalance () {
        return clearBalance;
    }

    public void setClearBalance (Double clearBalance) {
        this.clearBalance = clearBalance;
    }

    public String getMoneyType () {
        return moneyType;
    }

    public void setMoneyType (String moneyType) {
        this.moneyType = moneyType;
    }

    public String getEntrustStatus () {
        return entrustStatus;
    }

    public void setEntrustStatus (String entrustStatus) {
        this.entrustStatus = entrustStatus;
    }

    public String getExtPositionStr () {
        return extPositionStr;
    }

    public void setExtPositionStr (String extPositionStr) {
        this.extPositionStr = extPositionStr;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public Integer getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (Integer fundAccount) {
        this.fundAccount = fundAccount;
    }
}