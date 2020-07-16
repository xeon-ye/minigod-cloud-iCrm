package com.sunline.modules.quartz.entity;

import com.google.common.base.Objects;

import java.sql.Timestamp;

/**
 * @author LiYangFeng
 * @createDate 2017/3/23
 * @description 上游交互日志实体
 * @email justbelyf@gmail.com
 */
public class UpstreamInterfaceLog {
    // 全局ID
    private Long gid;

    // 业务主体类型
    private Integer businessSubType;

    // 业务主体类型Id
    private Integer businessSubTypeId;

    // 数据所属对象类型
    private Integer dataOwnerType;

    // 所属对象ID
    private String dataOwnerId;

    // 请求地址
    private String requestUrl;

    // 请求数据
    private String requestDataDetail;

    // 响应结果码
    private String errorCode;

    // 响应结果描述
    private String errorMsg;

    // 响应结果详细信息
    private String responseDataDetail;

    // 操作人员ID
    private String operatorId;

    // 操作结果
    private Integer operateResult;

    // 创建时间
    private Timestamp createTime;

    // 更新时间
    private Timestamp updateTime;

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Integer getBusinessSubType() {
        return businessSubType;
    }

    public void setBusinessSubType(Integer businessSubType) {
        this.businessSubType = businessSubType;
    }

    public Integer getBusinessSubTypeId() {
        return businessSubTypeId;
    }

    public void setBusinessSubTypeId(Integer businessSubTypeId) {
        this.businessSubTypeId = businessSubTypeId;
    }

    public Integer getDataOwnerType() {
        return dataOwnerType;
    }

    public void setDataOwnerType(Integer dataOwnerType) {
        this.dataOwnerType = dataOwnerType;
    }

    public String getDataOwnerId() {
        return dataOwnerId;
    }

    public void setDataOwnerId(String dataOwnerId) {
        this.dataOwnerId = dataOwnerId;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestDataDetail() {
        return requestDataDetail;
    }

    public void setRequestDataDetail(String requestDataDetail) {
        this.requestDataDetail = requestDataDetail;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResponseDataDetail() {
        return responseDataDetail;
    }

    public void setResponseDataDetail(String responseDataDetail) {
        this.responseDataDetail = responseDataDetail;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(Integer operateResult) {
        this.operateResult = operateResult;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("gid", gid)
                .add("businessSubType", businessSubType)
                .add("businessSubTypeId", businessSubTypeId)
                .add("dataOwnerType", dataOwnerType)
                .add("dataOwnerId", dataOwnerId)
                .add("requestUrl", requestUrl)
                .add("requestDataDetail", requestDataDetail)
                .add("errorCode", errorCode)
                .add("errorMsg", errorMsg)
                .add("responseDataDetail", responseDataDetail)
                .add("operatorId", operatorId)
                .add("operateResult", operateResult)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .toString();
    }
}
