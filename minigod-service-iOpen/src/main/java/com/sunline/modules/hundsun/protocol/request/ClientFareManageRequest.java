package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 客户费用管理请求协议
 * @author: Larry Lai
 * @date: 2018/8/21 15:07
 * @version: v1.0
 */

public class ClientFareManageRequest {
    /**
     * 客户号
     */
    @JSONField(name = "clientId")
    private String clientId;

    /**
     * 资金帐号
     */
    @JSONField(name = "fundAccount")
    private String fundAccount;

    /**
     * 费用类型[0-服务费 1-交易费]
     */
    @JSONField(name = "fareDict")
    private String fareDict;

    /**
     * 收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
     */
    @JSONField(name = "feeType")
    private String feeType;

    /**
     * 付费数值
     */
    @JSONField(name = "feeCount")
    private String feeCount;

    /**
     * 费用类别
     */
    @JSONField(name = "fareType")
    private String fareType;

    /**
     * 费用描述
     */
    @JSONField(name = "fareStr")
    private String fareStr;

    /**
     * 证券市场[K-港交所 P-美国市场]
     */
    @JSONField(name = "exchangeType")
    private String exchangeType;

    /**
     * 委托方式
     */
    @JSONField(name = "batchEntrustWay")
    private String[] batchEntrustWay;

    /**
     * 最低费用
     */
    @JSONField(name = "minFare")
    private String minFare;

    /**
     * 最高费用
     */
    @JSONField(name = "maxFare")
    private String maxFare;

    /**
     * 精度
     */
    @JSONField(name = "precisionFlag")
    private String precisionFlag;

    /**
     * 截位方式
     */
    @JSONField(name = "precision")
    private String precision;

    /**
     * 固定费用
     */
    @JSONField(name = "feeCountFix")
    private String feeCountFix;

    /**
     * 开始日期
     */
    @JSONField(name = "beginDate")
    private String beginDate;

    /**
     * 结束日期
     */
    @JSONField(name = "endDate")
    private String endDate;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getFareDict() {
        return fareDict;
    }

    public void setFareDict(String fareDict) {
        this.fareDict = fareDict;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeCount() {
        return feeCount;
    }

    public void setFeeCount(String feeCount) {
        this.feeCount = feeCount;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public String getFareStr() {
        return fareStr;
    }

    public void setFareStr(String fareStr) {
        this.fareStr = fareStr;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String[] getBatchEntrustWay() {
        return batchEntrustWay;
    }

    public void setBatchEntrustWay(String[] batchEntrustWay) {
        this.batchEntrustWay = batchEntrustWay;
    }

    public String getMinFare() {
        return minFare;
    }

    public void setMinFare(String minFare) {
        this.minFare = minFare;
    }

    public String getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(String maxFare) {
        this.maxFare = maxFare;
    }

    public String getPrecisionFlag() {
        return precisionFlag;
    }

    public void setPrecisionFlag(String precisionFlag) {
        this.precisionFlag = precisionFlag;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getFeeCountFix() {
        return feeCountFix;
    }

    public void setFeeCountFix(String feeCountFix) {
        this.feeCountFix = feeCountFix;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
