package com.sunline.modules.market.proxy.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * 行情套餐购买结果推送协议
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
public class MarketPackageResultRequest extends BaseParameter {
    /**
     * 预约号
     */
    @JSONField(name = "applicationId")
    private String applicationId;

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
}
