package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 出入金查询导出Excel模板
 * @author: fuyy
 * @date: 2018/11/28
 * @version: v1.0
 */

public class ClientFundDepositModel extends BaseRowModel {

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

    @ExcelProperty(value = "清算日期" ,index = 6)
    private String initDate;

    @ExcelProperty(value = "存款类型" ,index = 7)
    private String depositType;

    @ExcelProperty(value = "货币名称" ,index = 8)
    private String moneyType;

    @ExcelProperty(value = "资金发生数" ,index = 9)
    private String occurBalance;

    @ExcelProperty(value = "是否首次出入金" ,index = 10)
    private String firstDepFlag;

    @ExcelProperty(value = "备注" ,index = 11)
    private String remark;

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

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }

    public String getFirstDepFlag() {
        return firstDepFlag;
    }

    public void setFirstDepFlag(String firstDepFlag) {
        this.firstDepFlag = firstDepFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
