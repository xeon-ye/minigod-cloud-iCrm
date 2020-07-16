package com.sunline.modules.customer.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

/**
 * @author lcs
 * @date 2018-11-28
 * @description 综合查询导出model
 *
 */
public class CustomerSynModel extends BaseRowModel {
    @ExcelProperty(value = "序号" ,index = 0)
    private int id;
    @ExcelProperty(value = "开户日期" ,index = 1)
    private String openAccountTime;
    @ExcelProperty(value = "小神号" ,index = 2)
    private String userId;
    @ExcelProperty(value = "客户姓名" ,index = 3)
    private String clientName;
    @ExcelProperty(value = "客户帐号" ,index = 4)
    private String tradeAccount;
    @ExcelProperty(value = "证券手机号" ,index = 5)
    private String phoneNuber;
    @ExcelProperty(value = "注册来源" ,index = 6)
    private String regSourceType;
    @ExcelProperty(value = "来源标识" ,index = 7)
    private String regSource;
    @ExcelProperty(value = "渠道号" ,index = 8)
    private String sourceChannelId;
    @ExcelProperty(value = "全年收入" ,index = 9)
    private String annualIncome;
    @ExcelProperty(value = "入金次数" ,index = 10)
    private int depositInCount;
    @ExcelProperty(value = "出金次数" ,index = 11)
    private int depositOutCount;
    @ExcelProperty(value = "净资产HKD" ,index = 12)
    private String totalAssets;
    @ExcelProperty(value = "交易次数" ,index = 13)
    private int tradeCount;
    @ExcelProperty(value = "打新次数" ,index = 14)
    private int ipoCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
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

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getPhoneNuber() {
        return phoneNuber;
    }

    public void setPhoneNuber(String phoneNuber) {
        this.phoneNuber = phoneNuber;
    }

    public String getRegSourceType() {
        return regSourceType;
    }

    public void setRegSourceType(String regSourceType) {
        this.regSourceType = regSourceType;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getDepositInCount() {
        return depositInCount;
    }

    public void setDepositInCount(int depositInCount) {
        this.depositInCount = depositInCount;
    }

    public int getDepositOutCount() {
        return depositOutCount;
    }

    public void setDepositOutCount(int depositOutCount) {
        this.depositOutCount = depositOutCount;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public int getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(int tradeCount) {
        this.tradeCount = tradeCount;
    }

    public int getIpoCount() {
        return ipoCount;
    }

    public void setIpoCount(int ipoCount) {
        this.ipoCount = ipoCount;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }
}
