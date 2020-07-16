package com.sunline.modules.customer.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 小神用户资料Excel模板
 * @author: fu yanyan
 * @date: 2018/11/28
 * @version: v1.0
 */
public class CustomerUserModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "注册时间" ,index = 1)
    private String registerTime;

    @ExcelProperty(value = "最后活跃时间" ,index = 2)
    private String lastLoginTime;

    @ExcelProperty(value = "小神号" ,index = 3)
    private String userId;

    @ExcelProperty(value = "证券手机号" ,index = 4)
    private String phoneNumber;

    @ExcelProperty(value = "注册来源" ,index = 5)
    private String regSourceType;

    @ExcelProperty(value = "来源标识" ,index = 6)
    private String regSource;

    @ExcelProperty(value = "渠道号" ,index = 7)
    private String sourceChannelId;

    @ExcelProperty(value = "用户状态" ,index = 8)
    private String userStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegSourceType() {
        return regSourceType;
    }

    public void setRegSourceType(String regSourceType) {
        this.regSourceType = regSourceType;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
