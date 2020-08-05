package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;


/**
 * 增开申请
 * @author Tim
 * @createDate 2020/8/5
 */

public class AccountMarginOpenApplyProtocol extends BaseParameter {

    //预约流水号
    @JSONField(name = "applicationId")
    private String applicationId;

    //信用额度
    @JSONField(name = "creditQuota")
    private String creditQuota;

    //信用比例
    @JSONField(name = "creditRatio")
    private String creditRatio;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCreditQuota() {
        return creditQuota;
    }

    public void setCreditQuota(String creditQuota) {
        this.creditQuota = creditQuota;
    }

    public String getCreditRatio() {
        return creditRatio;
    }

    public void setCreditRatio(String creditRatio) {
        this.creditRatio = creditRatio;
    }
}
