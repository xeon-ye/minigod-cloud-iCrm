package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmTrdFundJour;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmTrdFundJour.class)
public class GrmTrdFundJour implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long jourId;
	private Date currDate;
	private String clientId;
	private Integer fundAccount;
	private String moneyType;
	private Integer businessFlag;
	private Double occurBalance;
	private Date valueDate;
	private String bankId;
	private String bankAccount;
	private String extPositionStr;
	private Integer extSerialNo;
	private String remark;
	private Date initDate;

    public Long getJourId () {
        return jourId;
    }

    public void setJourId (Long jourId) {
        this.jourId = jourId;
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

    public String getMoneyType () {
        return moneyType;
    }

    public void setMoneyType (String moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getBusinessFlag () {
        return businessFlag;
    }

    public void setBusinessFlag (Integer businessFlag) {
        this.businessFlag = businessFlag;
    }

    public Double getOccurBalance () {
        return occurBalance;
    }

    public void setOccurBalance (Double occurBalance) {
        this.occurBalance = occurBalance;
    }

    public Date getValueDate () {
        return valueDate;
    }

    public void setValueDate (Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getBankId () {
        return bankId;
    }

    public void setBankId (String bankId) {
        this.bankId = bankId;
    }

    public String getBankAccount () {
        return bankAccount;
    }

    public void setBankAccount (String bankAccount) {
        this.bankAccount = bankAccount;
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

    public Date getInitDate () {
        return initDate;
    }

    public void setInitDate (Date initDate) {
        this.initDate = initDate;
    }
}