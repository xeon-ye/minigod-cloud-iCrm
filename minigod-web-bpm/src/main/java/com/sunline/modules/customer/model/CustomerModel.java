package com.sunline.modules.customer.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 客户基本查询Excel模板
 * @author: fu yanyan
 * @date: 2018/11/28 16:33
 * @version: v1.0
 */
public class CustomerModel extends BaseRowModel {
    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "预约号" ,index = 1)
    private String applicationId;

    @ExcelProperty(value = "开户日期" ,index = 2)
    private String openAccountTime;

    @ExcelProperty(value = "开户途径" ,index = 3)
    private String openAccountType;

    @ExcelProperty(value = "小神号" ,index = 4)
    private String userId;

    @ExcelProperty(value = "客户帐号" ,index = 5)
    private String tradeAccount;

    @ExcelProperty(value = "中文姓名" ,index = 6)
    private String clientName;

    @ExcelProperty(value = "英文姓名" ,index = 7)
    private String clientNameSpell;

    @ExcelProperty(value = "证件类型" ,index = 8)
    private String idKind;

//    @ExcelProperty(value = "证件号" ,index = 9)
//    private String idNo;

    @ExcelProperty(value = "证券手机号" ,index = 9)
    private String phoneNumber;

    @ExcelProperty(value = "渠道号" ,index = 10)
    private String sourceChannelId;

    @ExcelProperty(value = "邀请人" ,index = 11)
    private String inviterId;

    @ExcelProperty(value = "邀请人姓名" ,index = 12)
    private String inviterName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getOpenAccountType() {
        return openAccountType;
    }

    public void setOpenAccountType(String openAccountType) {
        this.openAccountType = openAccountType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

//    public String getIdNo() {
//        return idNo;
//    }
//
//    public void setIdNo(String idNo) {
//        this.idNo = idNo;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName;
    }
}
