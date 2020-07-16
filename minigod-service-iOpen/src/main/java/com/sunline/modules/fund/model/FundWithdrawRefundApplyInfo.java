package com.sunline.modules.fund.model;

/**
 * @description: 出金退款申请工作流回调业务搭载
 * @author: Larry Lai
 * @date: 2019/4/2 14:00
 * @version: v1.0
 */

public class FundWithdrawRefundApplyInfo {

    private String applicationId;
    private String currentNode;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }
}
