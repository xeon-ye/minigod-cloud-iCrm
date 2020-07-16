package com.sunline.modules.account.online.model.query;

import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2018/1/17
 * @description
 * @email justbelyf@gmail.com
 */
public class AccountOpenApplyAllotQuery {
    private String status;
    // [1=全部 2=未分配 3=已分配]
    private Integer distributeType;
    private Integer approveResult;
    private String accountOpenApplicationId;
    private List<String> channelIds;
    private List<String> channelNames;
    private List<String> assignDrafters;
    private Long applicationStartTime;
    private Long applicationEndTime;
    private String customerServiceIds;
    private String customerServiceId;
    private String currentNode;

    public Integer getDistributeType() {
        return distributeType;
    }

    public void setDistributeType(Integer distributeType) {
        this.distributeType = distributeType;
    }

    public String getAccountOpenApplicationId() {
        return accountOpenApplicationId;
    }

    public void setAccountOpenApplicationId(String accountOpenApplicationId) {
        this.accountOpenApplicationId = accountOpenApplicationId;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public List<String> getChannelNames() {
        return channelNames;
    }

    public void setChannelNames(List<String> channelNames) {
        this.channelNames = channelNames;
    }

    public List<String> getAssignDrafters() {
        return assignDrafters;
    }

    public void setAssignDrafters(List<String> assignDrafters) {
        this.assignDrafters = assignDrafters;
    }

    public Long getApplicationStartTime() {
        return applicationStartTime;
    }

    public void setApplicationStartTime(Long applicationStartTime) {
        this.applicationStartTime = applicationStartTime;
    }

    public Long getApplicationEndTime() {
        return applicationEndTime;
    }

    public void setApplicationEndTime(Long applicationEndTime) {
        this.applicationEndTime = applicationEndTime;
    }

    public String getCustomerServiceIds() {
        return customerServiceIds;
    }

    public void setCustomerServiceIds(String customerServiceIds) {
        this.customerServiceIds = customerServiceIds;
    }

    public String getCustomerServiceId() {
        return customerServiceId;
    }

    public void setCustomerServiceId(String customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }
}
