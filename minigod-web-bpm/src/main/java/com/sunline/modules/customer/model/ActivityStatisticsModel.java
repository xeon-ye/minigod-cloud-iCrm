package com.sunline.modules.customer.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 活动统计
 * @author: Larry Lai
 * @date: 2019/6/12 14:54
 * @version: v1.0
 */

public class ActivityStatisticsModel extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 0)
    private String id;
    @ExcelProperty(value = "注册时间", index = 1)
    private String regTime;
    @ExcelProperty(value = "开户时间", index = 2)
    private String openAccountTime;
    @ExcelProperty(value = "首次入金日期", index = 3)
    private String firstDepositDate;
    @ExcelProperty(value = "首次交易日期", index = 4)
    private String firstTradeDate;
    @ExcelProperty(value = "首次入金金额", index = 5)
    private String firstDepositBalance;
    @ExcelProperty(value = "可用积分", index = 6)
    private String availablePoints;
    @ExcelProperty(value = "首次转入日期", index = 7)
    private String firstTransferDate;
    @ExcelProperty(value = "首次转入金额", index = 8)
    private String firstTransferBalance;
    @ExcelProperty(value = "小神号", index = 9)
    private String userId;
    @ExcelProperty(value = "注册手机号码", index = 10)
    private String regPhoneNumber;
    @ExcelProperty(value = "来源标识", index = 11)
    private String regSource;
    @ExcelProperty(value = "渠道号", index = 12)
    private String userSourceChannelId;
    @ExcelProperty(value = "最后活跃时间", index = 13)
    private String lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getFirstDepositDate() {
        return firstDepositDate;
    }

    public void setFirstDepositDate(String firstDepositDate) {
        this.firstDepositDate = firstDepositDate;
    }

    public String getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(String firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public String getFirstDepositBalance() {
        return firstDepositBalance;
    }

    public void setFirstDepositBalance(String firstDepositBalance) {
        this.firstDepositBalance = firstDepositBalance;
    }

    public String getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(String availablePoints) {
        this.availablePoints = availablePoints;
    }

    public String getFirstTransferDate() {
        return firstTransferDate;
    }

    public void setFirstTransferDate(String firstTransferDate) {
        this.firstTransferDate = firstTransferDate;
    }

    public String getFirstTransferBalance() {
        return firstTransferBalance;
    }

    public void setFirstTransferBalance(String firstTransferBalance) {
        this.firstTransferBalance = firstTransferBalance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegPhoneNumber() {
        return regPhoneNumber;
    }

    public void setRegPhoneNumber(String regPhoneNumber) {
        this.regPhoneNumber = regPhoneNumber;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }

    public String getUserSourceChannelId() {
        return userSourceChannelId;
    }

    public void setUserSourceChannelId(String userSourceChannelId) {
        this.userSourceChannelId = userSourceChannelId;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
