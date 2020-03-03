package com.minigod.api.grm.t2sdk.vo;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/6/30 19:53.
 * minigod
 */
public class FundJourRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String serialNo;
    protected String businessDate;
    protected String businessFlag;
    protected String businessName;
    protected String occurBalance;
    protected String postBalance;
    protected String moneyType;
    protected String remark;
    protected String positionStr;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(String businessFlag) {
        this.businessFlag = businessFlag;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPositionStr() {
        return positionStr;
    }

    public void setPositionStr(String positionStr) {
        this.positionStr = positionStr;
    }

    public String getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(String postBalance) {
        this.postBalance = postBalance;
    }
}
