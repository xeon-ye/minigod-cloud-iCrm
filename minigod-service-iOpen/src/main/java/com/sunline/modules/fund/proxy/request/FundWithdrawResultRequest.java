package com.sunline.modules.fund.proxy.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 出金业务审核处理结果推送协议
 * @author: Larry Lai
 * @date: 2019/4/10 13:48
 * @version: v1.0
 */

public class FundWithdrawResultRequest extends BaseParameter {

    /**
     * 预约号
     */
    @JSONField(name = "applicationId")
    private String applicationId;
    /**
     * 出金状态[0-已提交 1-已受理 2-已退回 3-已完成]
     */
    @JSONField(name = "withdrawStatus")
    private Integer withdrawStatus;

    /**
     * 退回理由
     */
    @JSONField(name = "backReason")
    private String backReason;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }
}
