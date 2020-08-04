package com.sunline.modules.account.online.model;

import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2018/3/20
 * @description
 * @email justbelyf@gmail.com
 */
public class AccountOpenApplyQuery {
    //业务流程状态  1=草稿 2=审批中 3=结束
    private String status;
    private String actResult;
    private Integer accountOpenResultStatus;
    private String customerAccountOpenInfoId;
    private String applicationId;
    private String userId;
    private Integer isMyTask;
    private String assignDrafter;
    private String clientName;
    private String idNo;
    private String email;
    private String phoneNumber;
    private String sourceChannelName;
    private String tradeAccount;
    private String applicationTimeStart;
    private String applicationTimeEnd;
    private Integer recordStatus;
    private String currentNode;
    private String businessCode;
    private Integer idKind;
    private Integer applicationStatus;
    private Integer bankType;
    private String updateUser;
    private String sourceChannelId;
    private String clientId;
    private Integer accountLevel;
    private Integer openAccountType;
    //是否导出EXCEL   0、未导出  1、已导出
    private Integer isExpExcel;

    /**
     * 开户类型[0=未知 1=互联网 2=线下开户 3=BPM]
     */
    public void setOpenAccountType(Integer openAccountType) {
        this.openAccountType = openAccountType;
    }
    /**
     * 开户类型[0=未知 1=互联网 2=线下开户 3=BPM]
     */
    public Integer getOpenAccountType() {
        return openAccountType;
    }

    public List<String> getCurrentNodes() {
        return currentNodes;
    }

    public void setCurrentNodes(List<String> currentNodes) {
        this.currentNodes = currentNodes;
    }

    private List<String> currentNodes;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    //是否为退回 [0-否 1-是]',
    private Integer isBack;

    public Integer getIsBack() {
        return isBack;
    }

    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActResult() {
        return actResult;
    }

    public void setActResult(String actResult) {
        this.actResult = actResult;
    }

    public Integer getAccountOpenResultStatus() {
        return accountOpenResultStatus;
    }

    public void setAccountOpenResultStatus(Integer accountOpenResultStatus) {
        this.accountOpenResultStatus = accountOpenResultStatus;
    }

    public String getCustomerAccountOpenInfoId() {
        return customerAccountOpenInfoId;
    }

    public void setCustomerAccountOpenInfoId(String customerAccountOpenInfoId) {
        this.customerAccountOpenInfoId = customerAccountOpenInfoId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSourceChannelName() {
        return sourceChannelName;
    }

    public void setSourceChannelName(String sourceChannelName) {
        this.sourceChannelName = sourceChannelName;
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getApplicationTimeStart() {
        return applicationTimeStart;
    }

    public void setApplicationTimeStart(String applicationTimeStart) {
        this.applicationTimeStart = applicationTimeStart;
    }

    public String getApplicationTimeEnd() {
        return applicationTimeEnd;
    }

    public void setApplicationTimeEnd(String applicationTimeEnd) {
        this.applicationTimeEnd = applicationTimeEnd;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAssignDrafter() {
        return assignDrafter;
    }

    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }

    public Integer getIsMyTask() {
        return isMyTask;
    }

    public void setIsMyTask(Integer isMyTask) {
        this.isMyTask = isMyTask;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Integer getIdKind() {
        return idKind;
    }

    public void setIdKind(Integer idKind) {
        this.idKind = idKind;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer openAccountStatus) {
        this.applicationStatus = openAccountStatus;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Integer getIsExpExcel() {
        return isExpExcel;
    }

    public void setIsExpExcel(Integer isExpExcel) {
        this.isExpExcel = isExpExcel;
    }
}
