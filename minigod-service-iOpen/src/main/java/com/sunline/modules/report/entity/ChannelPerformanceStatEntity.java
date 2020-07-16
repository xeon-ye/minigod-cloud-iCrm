package com.sunline.modules.report.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 渠道业绩统计报表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-07-24 21:38:18
 */
public class ChannelPerformanceStatEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 渠道号
     */
    private String channelId;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 新增用户数
     */
    private String addUserQuantity;
    /**
     * 累计用户数
     */
    private String totalUserQuantity;
    /**
     * 新增开户数
     */
    private String addClientQuantity;
    /**
     * 累计开户数
     */
    private String totalClientQuantity;
    /**
     * 新增入金客户数
     */
    private String addDepClientQuantity;
    /**
     * 累计入金客户数
     */
    private String totalDepClientQuantity;
    /**
     * 新增出金客户数
     */
    private String addWitClientQuantity;
    /**
     * 累计出金客户数
     */
    private String totalWitClientQuantity;
    /**
     * 新增转仓客户数
     */
    private String addStkTranQuantity;
    /**
     * 累计转仓客户数
     */
    private String totalStkTranQuantity;
    /**
     * 新增交易客户数
     */
    private String addTradeClientQuantity;
    /**
     * 累计交易客户数
     */
    private String totalTradeClientQuantity;
    /**
     * 新增入金金额数
     */
    private String addIncomeBalance;
    /**
     * 累计入金金额数
     */
    private String totalIncomeBalance;
    /**
     * 新增出金金额数
     */
    private String addOutBalance;
    /**
     * 累计出金金额数
     */
    private String totalOutBalance;
    /**
     * 新增成交数量
     */
    private String addTradeAmount;
    /**
     * 累计成交数量
     */
    private String totalTradeAmount;
    /**
     * 新增成交金额
     */
    private String addTradeBalance;
    /**
     * 累计成交金额
     */
    private String totalTradeBalance;
    /**
     * 新增交易佣金
     */
    private String addTradeBrokerage;
    /**
     * 累计交易佣金
     */
    private String totalTradeBrokerage;
    /**
     * 新增总资产
     */
    private String addClientAsset;
    /**
     * 累计总资产
     */
    private String totalClientAsset;
    /**
     * 授权渠道
     */
    private List<String> channelIds;
    /**
     * 开始日期
     */
    private String beginDate;
    /**
     * 结束日期
     */
    private String endDate;


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

    public String getAddUserQuantity() {
        return addUserQuantity;
    }

    public void setAddUserQuantity(String addUserQuantity) {
        this.addUserQuantity = addUserQuantity;
    }

    public String getTotalUserQuantity() {
        return totalUserQuantity;
    }

    public void setTotalUserQuantity(String totalUserQuantity) {
        this.totalUserQuantity = totalUserQuantity;
    }

    public String getAddClientQuantity() {
        return addClientQuantity;
    }

    public void setAddClientQuantity(String addClientQuantity) {
        this.addClientQuantity = addClientQuantity;
    }

    public String getTotalClientQuantity() {
        return totalClientQuantity;
    }

    public void setTotalClientQuantity(String totalClientQuantity) {
        this.totalClientQuantity = totalClientQuantity;
    }

    public String getAddDepClientQuantity() {
        return addDepClientQuantity;
    }

    public void setAddDepClientQuantity(String addDepClientQuantity) {
        this.addDepClientQuantity = addDepClientQuantity;
    }

    public String getTotalDepClientQuantity() {
        return totalDepClientQuantity;
    }

    public void setTotalDepClientQuantity(String totalDepClientQuantity) {
        this.totalDepClientQuantity = totalDepClientQuantity;
    }

    public String getAddWitClientQuantity() {
        return addWitClientQuantity;
    }

    public void setAddWitClientQuantity(String addWitClientQuantity) {
        this.addWitClientQuantity = addWitClientQuantity;
    }

    public String getTotalWitClientQuantity() {
        return totalWitClientQuantity;
    }

    public void setTotalWitClientQuantity(String totalWitClientQuantity) {
        this.totalWitClientQuantity = totalWitClientQuantity;
    }

    public String getAddStkTranQuantity() {
        return addStkTranQuantity;
    }

    public void setAddStkTranQuantity(String addStkTranQuantity) {
        this.addStkTranQuantity = addStkTranQuantity;
    }

    public String getTotalStkTranQuantity() {
        return totalStkTranQuantity;
    }

    public void setTotalStkTranQuantity(String totalStkTranQuantity) {
        this.totalStkTranQuantity = totalStkTranQuantity;
    }

    public String getAddTradeClientQuantity() {
        return addTradeClientQuantity;
    }

    public void setAddTradeClientQuantity(String addTradeClientQuantity) {
        this.addTradeClientQuantity = addTradeClientQuantity;
    }

    public String getTotalTradeClientQuantity() {
        return totalTradeClientQuantity;
    }

    public void setTotalTradeClientQuantity(String totalTradeClientQuantity) {
        this.totalTradeClientQuantity = totalTradeClientQuantity;
    }

    public String getAddIncomeBalance() {
        return addIncomeBalance;
    }

    public void setAddIncomeBalance(String addIncomeBalance) {
        this.addIncomeBalance = addIncomeBalance;
    }

    public String getTotalIncomeBalance() {
        return totalIncomeBalance;
    }

    public void setTotalIncomeBalance(String totalIncomeBalance) {
        this.totalIncomeBalance = totalIncomeBalance;
    }

    public String getAddOutBalance() {
        return addOutBalance;
    }

    public void setAddOutBalance(String addOutBalance) {
        this.addOutBalance = addOutBalance;
    }

    public String getTotalOutBalance() {
        return totalOutBalance;
    }

    public void setTotalOutBalance(String totalOutBalance) {
        this.totalOutBalance = totalOutBalance;
    }

    public String getAddTradeAmount() {
        return addTradeAmount;
    }

    public void setAddTradeAmount(String addTradeAmount) {
        this.addTradeAmount = addTradeAmount;
    }

    public String getTotalTradeAmount() {
        return totalTradeAmount;
    }

    public void setTotalTradeAmount(String totalTradeAmount) {
        this.totalTradeAmount = totalTradeAmount;
    }

    public String getAddTradeBalance() {
        return addTradeBalance;
    }

    public void setAddTradeBalance(String addTradeBalance) {
        this.addTradeBalance = addTradeBalance;
    }

    public String getTotalTradeBalance() {
        return totalTradeBalance;
    }

    public void setTotalTradeBalance(String totalTradeBalance) {
        this.totalTradeBalance = totalTradeBalance;
    }

    public String getAddTradeBrokerage() {
        return addTradeBrokerage;
    }

    public void setAddTradeBrokerage(String addTradeBrokerage) {
        this.addTradeBrokerage = addTradeBrokerage;
    }

    public String getTotalTradeBrokerage() {
        return totalTradeBrokerage;
    }

    public void setTotalTradeBrokerage(String totalTradeBrokerage) {
        this.totalTradeBrokerage = totalTradeBrokerage;
    }

    public String getAddClientAsset() {
        return addClientAsset;
    }

    public void setAddClientAsset(String addClientAsset) {
        this.addClientAsset = addClientAsset;
    }

    public String getTotalClientAsset() {
        return totalClientAsset;
    }

    public void setTotalClientAsset(String totalClientAsset) {
        this.totalClientAsset = totalClientAsset;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
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
