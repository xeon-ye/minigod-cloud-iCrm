package com.sunline.modules.account.online.model.query;

/**
 * @author LiYangFeng
 * @createDate 2018/3/20
 * @description
 * @email justbelyf@gmail.com
 */
public class AccountOpenQuery {
    //业务流程状态  1=草稿 2=审批中 3=结束
    private String status;
    private String actResult;
    private Integer accountOpenResultStatus;
    private String customerAccountOpenInfoId;
    private String applicationId;
    private String userId;
    private String clientName;
    private String idNo;
    private String email;
    private String phoneNumber;
    private String sourceChannelName;
    private String tradeAccount;
    private Long applicationTimeStart;
    private Long applicationTimeEnd;
    private Integer recordStatus;

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

    public Long getApplicationTimeStart() {
        return applicationTimeStart;
    }

    public void setApplicationTimeStart(Long applicationTimeStart) {
        this.applicationTimeStart = applicationTimeStart;
    }

    public Long getApplicationTimeEnd() {
        return applicationTimeEnd;
    }

    public void setApplicationTimeEnd(Long applicationTimeEnd) {
        this.applicationTimeEnd = applicationTimeEnd;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}
