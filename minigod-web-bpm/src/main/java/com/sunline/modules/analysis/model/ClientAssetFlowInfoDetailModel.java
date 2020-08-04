package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 资金查询导出Excel模板
 * @author: fuyy
 * @date: 2018/11/28
 * @version: v1.0
 */

public class ClientAssetFlowInfoDetailModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "小神号" ,index = 1)
    private String userId;

    @ExcelProperty(value = "客户姓名" ,index = 2)
    private String clientName;

    @ExcelProperty(value = "交易帐号" ,index = 3)
    private String clientId;

    @ExcelProperty(value = "资金帐号" ,index = 4)
    private String fundAccount;

    @ExcelProperty(value = "渠道" ,index = 5)
    private String channelId;

    @ExcelProperty(value = "交易日期" ,index = 6)
    private String tradeDate;

    @ExcelProperty(value = "币种代码" ,index = 7)
    private String moneyType;

    @ExcelProperty(value = "现金余额" ,index = 8)
    private String currentBalance;

    @ExcelProperty(value = "冻结资金" ,index = 9)
    private String frozenBalance;

    @ExcelProperty(value = "证券市值" ,index = 10)
    private String marketValueCur;

    @ExcelProperty(value = "总资产" ,index = 11)
    private String totalAssets;

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

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getMarketValueCur() {
        return marketValueCur;
    }

    public void setMarketValueCur(String marketValueCur) {
        this.marketValueCur = marketValueCur;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }
}
