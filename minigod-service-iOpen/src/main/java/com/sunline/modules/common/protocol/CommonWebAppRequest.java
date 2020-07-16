package com.sunline.modules.common.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/7/25
 * @description
 * @email justbelyf@gmail.com
 */
public class CommonWebAppRequest {
    @JSONField(name = "sessionId")
    private String sessionId;//会话ID

    @JSONField(name = "requestSource")
    private String requestSource;//请求来源类型

    @JSONField(name = "requestSourceType")
    private Integer requestSourceType;//请求来源type

    @JSONField(name = "operatorType")
    private Integer operatorType;//请求操作系统类型

    @JSONField(name = "isLastCommitStep")
    private Integer isLastCommitStep;//上次提交步骤


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public Integer getRequestSourceType() {
        return requestSourceType;
    }

    public void setRequestSourceType(Integer requestSourceType) {
        this.requestSourceType = requestSourceType;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public Integer getIsLastCommitStep() {
        return isLastCommitStep;
    }

    public void setIsLastCommitStep(Integer isLastCommitStep) {
        this.isLastCommitStep = isLastCommitStep;
    }
}
