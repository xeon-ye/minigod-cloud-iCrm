package com.sunline.modules.market.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 行情购买记录导出excel模板
 * @author: jim
 * @date: 2019/5/17 10:30
 */
public class MarketPackageExportModel extends BaseRowModel {
    @ExcelProperty(value = "购买日期", index = 0)
    private String buyDate;

    @ExcelProperty(value = "小神号", index = 1)
    private String userId;

    @ExcelProperty(value = "客户帐号", index = 2)
    private String clientId;

    @ExcelProperty(value = "资金帐号", index = 3)
    private String fundAccount;

    @ExcelProperty(value = "客户姓名", index = 4)
    private String clientName;

    @ExcelProperty(value = "手机号码", index = 5)
    private String phoneNumber;

    @ExcelProperty(value = "行情套餐", index = 6)
    private String packageName;

    @ExcelProperty(value = "单价(HKD)", index = 7)
    private String packagePrice;

    @ExcelProperty(value = "有效期(月数)", index = 8)
    private String validityPeriod;

    @ExcelProperty(value = "总价(HKD)", index = 9)
    private String totalCost;

    @ExcelProperty(value = "扣款状态", index = 10)
    private String deductionStatus;

    /**
     * 获取 buyDate
     *
     * @return buyDate
     */
    public String getBuyDate() {
        return buyDate;
    }

    /**
     * 设置 buyDate
     */
    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * 获取 userId
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 clientId
     *
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置 clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取 fundAccount
     *
     * @return fundAccount
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置 fundAccount
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取 clientName
     *
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置 clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取 phoneNumber
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置 phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取 packageName
     *
     * @return packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 设置 packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 获取 packagePrice
     *
     * @return packagePrice
     */
    public String getPackagePrice() {
        return packagePrice;
    }

    /**
     * 设置 packagePrice
     */
    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    /**
     * 获取 validityPeriod
     *
     * @return validityPeriod
     */
    public String getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * 设置 validityPeriod
     */
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /**
     * 获取 totalCost
     *
     * @return totalCost
     */
    public String getTotalCost() {
        return totalCost;
    }

    /**
     * 设置 totalCost
     */
    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * 获取 deductionStatus
     *
     * @return deductionStatus
     */
    public String getDeductionStatus() {
        return deductionStatus;
    }

    /**
     * 设置 deductionStatus
     */
    public void setDeductionStatus(String deductionStatus) {
        this.deductionStatus = deductionStatus;
    }
}
