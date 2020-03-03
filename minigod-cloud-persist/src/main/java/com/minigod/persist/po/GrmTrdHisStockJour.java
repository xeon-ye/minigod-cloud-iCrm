package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmTrdHisStockJour;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmTrdHisStockJour.class)
public class GrmTrdHisStockJour implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long jourId;
	private Date initDate;
	private Date currDate;
	private String clientId;
	private Integer fundAccount;
	private Integer moneyType;
	private Integer businessFlag;
	private String assetId;
	private String stockCode;
	private String market;
	private Long occurAmount;
	private Long postAmount;
	private String extPositionStr;
	private Integer extSerialNo;
	private String remark;

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

    public Integer getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (Integer fundAccount) {
        this.fundAccount = fundAccount;
    }

    public Integer getMoneyType () {
        return moneyType;
    }

    public void setMoneyType (Integer moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getBusinessFlag () {
        return businessFlag;
    }

    public void setBusinessFlag (Integer businessFlag) {
        this.businessFlag = businessFlag;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public String getStockCode () {
        return stockCode;
    }

    public void setStockCode (String stockCode) {
        this.stockCode = stockCode;
    }

    public String getMarket () {
        return market;
    }

    public void setMarket (String market) {
        this.market = market;
    }

    public Long getOccurAmount () {
        return occurAmount;
    }

    public void setOccurAmount (Long occurAmount) {
        this.occurAmount = occurAmount;
    }

    public Long getPostAmount () {
        return postAmount;
    }

    public void setPostAmount (Long postAmount) {
        this.postAmount = postAmount;
    }

    public String getExtPositionStr () {
        return extPositionStr;
    }

    public void setExtPositionStr (String extPositionStr) {
        this.extPositionStr = extPositionStr;
    }

    public Integer getExtSerialNo () {
        return extSerialNo;
    }

    public void setExtSerialNo (Integer extSerialNo) {
        this.extSerialNo = extSerialNo;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}