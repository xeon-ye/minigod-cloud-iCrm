package com.sunline.modules.stock.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 领取列表Excel模板
 * @author: fu yanyan
 * @date: 2018/11/28 16:33
 * @version: v1.0
 */
public class DonatedStockApplicationInfoModel extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 0)
    private String id;

    @ExcelProperty(value = "领取时间", index = 1)
    private String receiveTime;

    @ExcelProperty(value = "活动ID", index = 2)
    private String activityId;

    @ExcelProperty(value = "渠道号", index = 3)
    private String channelId;

    @ExcelProperty(value = "渠道名称", index = 4)
    private String channelName;

    @ExcelProperty(value = "开户途径", index = 5)
    private String bankType;

    @ExcelProperty(value = "小神号", index = 6)
    private Integer userId;

    @ExcelProperty(value = "客户帐号", index = 7)
    private String clientId;

    @ExcelProperty(value = "客户名称", index = 8)
    private String clientName;

    @ExcelProperty(value = "证券手机号", index = 9)
    private String phoneNumber;

    @ExcelProperty(value = "股票代码", index = 10)
    private String stockCode;

    @ExcelProperty(value = "股票名称", index = 11)
    private String stockName;

    @ExcelProperty(value = "股票数量", index = 12)
    private String stockQuantity;

    @ExcelProperty(value = "平均成本HKD", index = 13)
    private String totalCost;

    @ExcelProperty(value = "状态", index = 14)
    private String applicationStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
