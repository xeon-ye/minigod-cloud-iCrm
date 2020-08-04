package com.sunline.modules.call.protocol.request;

/**
 * @description: 查询通话记录入参协议
 * @author: Larry Lai
 * @date: 2019/3/5 10:39
 * @version: v1.0
 */

public class CallRecordRequest {

    private String beginTime;
    private String endTime;
    private String callNo;
    private String calledNo;
    private String connectType;
    private String status;
    private String cdrVar;
    private String resultParams;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getCalledNo() {
        return calledNo;
    }

    public void setCalledNo(String calledNo) {
        this.calledNo = calledNo;
    }

    public String getConnectType() {
        return connectType;
    }

    public void setConnectType(String connectType) {
        this.connectType = connectType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCdrVar() {
        return cdrVar;
    }

    public void setCdrVar(String cdrVar) {
        this.cdrVar = cdrVar;
    }

    public String getResultParams() {
        return resultParams;
    }

    public void setResultParams(String resultParams) {
        this.resultParams = resultParams;
    }
}
