package com.sunline.modules.customer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 活动统计
 * @author: Larry Lai
 * @date: 2019/6/12 14:54
 * @version: v1.0
 */

public class ActivityStatisticsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date regTime;
    private Date openAccountTime;
    private Date firstDepositDate;
    private Date firstTradeDate;
    private BigDecimal firstDepositBalance;
    private Integer availablePoints;
    private Date firstTransferDate;
    private BigDecimal firstTransferBalance;
    private Integer userId;
    private String regPhoneNumber;
    private String regSource;
    private Integer userSourceChannelId;
    private Date lastLoginTime;
    private String regStartTime;
    private String regEndTime;
    private String lastLoginStartTime;
    private String lastLoginEndTime;
    private List<String> channelIds;
    private String checkedChannelId;
    private List<String> checkedChannelIds;
    private String sourceChannelName;


    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public Date getFirstDepositDate() {
        return firstDepositDate;
    }

    public void setFirstDepositDate(Date firstDepositDate) {
        this.firstDepositDate = firstDepositDate;
    }

    public Date getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(Date firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public BigDecimal getFirstDepositBalance() {
        return firstDepositBalance;
    }

    public void setFirstDepositBalance(BigDecimal firstDepositBalance) {
        this.firstDepositBalance = firstDepositBalance;
    }

    public Integer getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(Integer availablePoints) {
        this.availablePoints = availablePoints;
    }

    public Date getFirstTransferDate() {
        return firstTransferDate;
    }

    public void setFirstTransferDate(Date firstTransferDate) {
        this.firstTransferDate = firstTransferDate;
    }

    public BigDecimal getFirstTransferBalance() {
        return firstTransferBalance;
    }

    public void setFirstTransferBalance(BigDecimal firstTransferBalance) {
        this.firstTransferBalance = firstTransferBalance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getUserSourceChannelId() {
        return userSourceChannelId;
    }

    public void setUserSourceChannelId(Integer userSourceChannelId) {
        this.userSourceChannelId = userSourceChannelId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRegStartTime() {
        return regStartTime;
    }

    public void setRegStartTime(String regStartTime) {
        this.regStartTime = regStartTime;
    }

    public String getRegEndTime() {
        return regEndTime;
    }

    public void setRegEndTime(String regEndTime) {
        this.regEndTime = regEndTime;
    }

    public String getLastLoginStartTime() {
        return lastLoginStartTime;
    }

    public void setLastLoginStartTime(String lastLoginStartTime) {
        this.lastLoginStartTime = lastLoginStartTime;
    }

    public String getLastLoginEndTime() {
        return lastLoginEndTime;
    }

    public void setLastLoginEndTime(String lastLoginEndTime) {
        this.lastLoginEndTime = lastLoginEndTime;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public String getSourceChannelName() {
        return sourceChannelName;
    }

    public void setSourceChannelName(String sourceChannelName) {
        this.sourceChannelName = sourceChannelName;
    }
}
