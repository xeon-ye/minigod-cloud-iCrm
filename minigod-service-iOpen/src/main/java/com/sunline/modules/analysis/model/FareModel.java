package com.sunline.modules.analysis.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 客户佣金套餐导出Excel模板
 * @author: fuyy
 * @date: 2018/11/27 16:33
 * @version: v1.0
 */


public class FareModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "小神号" ,index = 1)
    private String userId;

    @ExcelProperty(value = "姓名" ,index = 2)
    private String clientName;

    @ExcelProperty(value = "交易帐号" ,index = 3)
    private String clientId;

    @ExcelProperty(value = "资金帐号" ,index = 4)
    private String fundAccount;

    @ExcelProperty(value = "渠道" ,index = 5)
    private String channelId;

    @ExcelProperty(value = "原套餐" ,index = 6)
    private String lastFareKind;

    @ExcelProperty(value = "新套餐" ,index = 7)
    private String fareKind;

    @ExcelProperty(value = "修改人" ,index = 8)
    private String updateUser;

    @ExcelProperty(value = "修改时间" ,index = 9)
    private String modifyTime;

    @ExcelProperty(value = "审核状态" ,index = 10)
    private String auditStatus;

    @ExcelProperty(value = "同步状态" ,index = 11)
    private String syncStatus;

    @ExcelProperty(value = "证券市场" ,index = 12)
    private String exchangeType;

    @ExcelProperty(value = "费用类型" ,index = 13)
    private String fareDict;

    @ExcelProperty(value = "收费方式" ,index = 14)
    private String feeType;

    @ExcelProperty(value = "付费数值" ,index = 15)
    private String feeCount;

    @ExcelProperty(value = "最低费用" ,index = 16)
    private String minFare;

    @ExcelProperty(value = "最高费用" ,index = 17)
    private String maxFare;

    @ExcelProperty(value = "开始日期" ,index = 18)
    private String beginDate;

    @ExcelProperty(value = "结束日期" ,index = 19)
    private String endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLastFareKind() {
        return lastFareKind;
    }

    public void setLastFareKind(String lastFareKind) {
        this.lastFareKind = lastFareKind;
    }

    public String getFareKind() {
        return fareKind;
    }

    public void setFareKind(String fareKind) {
        this.fareKind = fareKind;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
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
