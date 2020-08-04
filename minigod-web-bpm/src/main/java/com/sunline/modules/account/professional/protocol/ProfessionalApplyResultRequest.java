package com.sunline.modules.account.professional.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;
import lombok.Data;

@Data
public class ProfessionalApplyResultRequest extends BaseParameter {
    /**
     * 预约号
     */
    @JSONField(name = "applicationId")
    private String applicationId;
    /**
     * 处理状态 1-初审中 2-复审中 3-认定成功 4-已退回 5-已终止 6-已撤销 7-已失效 8-即将到期
     */
    @JSONField(name = "applyStatus")
    private Integer applyStatus;

    //退回理由
    @JSONField(name = "backReason")
    private String backReason;

    public ProfessionalApplyResultRequest(String applicationId, Integer applyStatus,String backReason) {
        this.applicationId = applicationId;
        this.applyStatus = applyStatus;
        this.backReason = backReason;
    }

}
