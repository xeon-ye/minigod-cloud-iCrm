package com.minigod.api.inform.vo;

import java.io.Serializable;
import java.util.*;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 15:08 2017/10/20
 * @Modified By:
 */
public class SendSmsVO implements Serializable{

    private List<Integer> userIds; // 用户ID
    private String phone; // 手机号码
    private String message; // 短信内容
    private Integer templateCode; // 模板编码
    private String description; // 业务描述
    private Integer userType; // 用户类型
    private Integer sendType; // 定时和即时
    private Date timing; // 定时时间

    // 针对BPM调用短信接口，需要传入参数
    private Integer requestSource = 0; // 0：本地 1：外部系统调用

    private Map<String , Object> paramMap = new HashMap<String , Object>();

    private List<String> params = new ArrayList<String>();

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(Integer templateCode) {
        this.templateCode = templateCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
    }

    public Integer getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(Integer requestSource) {
        this.requestSource = requestSource;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
