package com.sunline.modules.fund.model;

public class ClientFundDepositWorkFlow {
    private String applicationId;
    private String currentNode;

    /**
     * 获取 applicationId
     *
     * @return applicationId
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置 applicationId
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取 currentNode
     *
     * @return currentNode
     */
    public String getCurrentNode() {
        return currentNode;
    }

    /**
     * 设置 currentNode
     */
    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }
}
