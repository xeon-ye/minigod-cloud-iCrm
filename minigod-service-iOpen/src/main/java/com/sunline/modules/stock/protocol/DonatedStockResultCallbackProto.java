package com.sunline.modules.stock.protocol;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author fuyy
 * @createDate 2018/12/11
 * @description
 * @email
 */
public class DonatedStockResultCallbackProto {

    /**
     * 流水号
     */
    @JSONField(name = "applicationId")
    private String applicationId;

    /**
     * 赠送状态 [0-已领取 1-已到账 2-赠送失败]
     */
    @JSONField(name = "handselStatus")
    private Integer handselStatus;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getHandselStatus() {
        return handselStatus;
    }

    public void setHandselStatus(Integer handselStatus) {
        this.handselStatus = handselStatus;
    }
}
