package com.sunline.modules.fund.proxy.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 入金业务审核处理结果推送协议
 * @author: jim
 * @date: 2019/6/2 13:48
 */
public class FundDepositResultRequest extends BaseParameter {

    /**
     * 预约号
     */
    @JSONField(name = "applicationId")
    private String applicationId;
    /**
     * 入金状态 0已提交 1已受理 2已退回 3已完成
     */
    @JSONField(name = "depositStatus")
    private Integer depositStatus;

    //退回理由
    @JSONField(name = "backReason")
    private String backReason;
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取 depositStatus
     *
     * @return depositStatus
     */
    public Integer getDepositStatus() {
        return depositStatus;
    }

    /**
     * 设置 depositStatus
     */
    public void setDepositStatus(Integer depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public FundDepositResultRequest(String applicationId, Integer depositStatus, String backReason) {
        this.applicationId = applicationId;
        this.depositStatus = depositStatus;
        this.backReason = backReason;
    }
}
