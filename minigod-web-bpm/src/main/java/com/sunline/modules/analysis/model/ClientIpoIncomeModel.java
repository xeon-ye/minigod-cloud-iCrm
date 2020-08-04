package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 活动打新统计导出Excel模板
 * @author: fuyy
 * @date: 2018/11/28 16:44
 * @version: v1.0
 */

public class ClientIpoIncomeModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "小神号" ,index = 1)
    private String userId;

    @ExcelProperty(value = "注册日期" ,index = 2)
    private String registerDate;

    @ExcelProperty(value = "开户日期" ,index = 3)
    private String openAccountDate;

    @ExcelProperty(value = "首次入金日期" ,index = 4)
    private String firstIncomeDate;

    @ExcelProperty(value = "首次入金金额" ,index = 5)
    private String firstIncomeMoney;

    @ExcelProperty(value = "活动入金金额" ,index = 6)
    private String ipoIncomeMoney;

    @ExcelProperty(value = "活动认购笔数" ,index = 7)
    private String ipoApplyCount;

    @ExcelProperty(value = "邀请人数" ,index = 8)
    private String inviteCount;

    @ExcelProperty(value = "邀请入金金额" ,index = 9)
    private String inviteIncomeMoney;

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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getOpenAccountDate() {
        return openAccountDate;
    }

    public void setOpenAccountDate(String openAccountDate) {
        this.openAccountDate = openAccountDate;
    }

    public String getFirstIncomeDate() {
        return firstIncomeDate;
    }

    public void setFirstIncomeDate(String firstIncomeDate) {
        this.firstIncomeDate = firstIncomeDate;
    }

    public String getFirstIncomeMoney() {
        return firstIncomeMoney;
    }

    public void setFirstIncomeMoney(String firstIncomeMoney) {
        this.firstIncomeMoney = firstIncomeMoney;
    }

    public String getIpoIncomeMoney() {
        return ipoIncomeMoney;
    }

    public void setIpoIncomeMoney(String ipoIncomeMoney) {
        this.ipoIncomeMoney = ipoIncomeMoney;
    }

    public String getIpoApplyCount() {
        return ipoApplyCount;
    }

    public void setIpoApplyCount(String ipoApplyCount) {
        this.ipoApplyCount = ipoApplyCount;
    }

    public String getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(String inviteCount) {
        this.inviteCount = inviteCount;
    }

    public String getInviteIncomeMoney() {
        return inviteIncomeMoney;
    }

    public void setInviteIncomeMoney(String inviteIncomeMoney) {
        this.inviteIncomeMoney = inviteIncomeMoney;
    }
}
