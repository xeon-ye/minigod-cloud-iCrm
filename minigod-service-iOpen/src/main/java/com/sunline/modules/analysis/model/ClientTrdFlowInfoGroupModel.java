package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 交易汇总导出Excel模板
 * @author: Larry Lai
 * @date: 2018/11/27 16:33
 * @version: v1.0
 */

public class ClientTrdFlowInfoGroupModel extends BaseRowModel {

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

    @ExcelProperty(value = "成交数量" ,index = 6)
    private String businessAmount;

    @ExcelProperty(value = "成交金额" ,index = 7)
    private String businessBalance;

    @ExcelProperty(value = "清算金额" ,index = 8)
    private String occurBalance;

    @ExcelProperty(value = "佣金" ,index = 9)
    private String feeCount;

    @ExcelProperty(value = "净佣金" ,index = 10)
    private String profitFeeCount;

    @ExcelProperty(value = "佣金比例(%)" ,index = 11)
    private String feeCountRatio;

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

    public String getBusinessAmount() {
        return businessAmount;
    }

    public void setBusinessAmount(String businessAmount) {
        this.businessAmount = businessAmount;
    }

    public String getBusinessBalance() {
        return businessBalance;
    }

    public void setBusinessBalance(String businessBalance) {
        this.businessBalance = businessBalance;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getFeeCount() {
        return feeCount;
    }

    public void setFeeCount(String feeCount) {
        this.feeCount = feeCount;
    }

    public String getProfitFeeCount() {
        return profitFeeCount;
    }

    public void setProfitFeeCount(String profitFeeCount) {
        this.profitFeeCount = profitFeeCount;
    }

    public String getFeeCountRatio() {
        return feeCountRatio;
    }

    public void setFeeCountRatio(String feeCountRatio) {
        this.feeCountRatio = feeCountRatio;
    }
}
