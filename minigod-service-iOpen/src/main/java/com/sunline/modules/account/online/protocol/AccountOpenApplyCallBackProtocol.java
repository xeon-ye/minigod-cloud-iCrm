package com.sunline.modules.account.online.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.util.List;

/**
 * @description: 开户申请回调接口调用协议
 * @author: Larry Lai
 * @date: 2019/1/2 14:44
 * @version: v1.0
 */

public class AccountOpenApplyCallBackProtocol extends BaseParameter {

    private static final long serialVersionUID = -3468402770583647268L;

    /**
     * 预约流水号
     */
    private String applicationId;

    /**
     * CA认证状态
     */
    private Integer caVerifyStatus;

    /**
     * CA认证错误信息
     */
    private String caVerifyMsg;

    /**
     * CA签署码
     */
    private String caSignHashCode;

    /**
     * CA证书申请记录
     */
    private List<CaVerityInfoProtocol> caVerityInfoList;

    /**
     * CA认证签署文件路径
     */
    private String caVerifyFileUrl;


    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getCaVerifyStatus() {
        return caVerifyStatus;
    }

    public void setCaVerifyStatus(Integer caVerifyStatus) {
        this.caVerifyStatus = caVerifyStatus;
    }

    public String getCaVerifyMsg() {
        return caVerifyMsg;
    }

    public void setCaVerifyMsg(String caVerifyMsg) {
        this.caVerifyMsg = caVerifyMsg;
    }

    public String getCaSignHashCode() {
        return caSignHashCode;
    }

    public void setCaSignHashCode(String caSignHashCode) {
        this.caSignHashCode = caSignHashCode;
    }

    public List<CaVerityInfoProtocol> getCaVerityInfoList() {
        return caVerityInfoList;
    }

    public void setCaVerityInfoList(List<CaVerityInfoProtocol> caVerityInfoList) {
        this.caVerityInfoList = caVerityInfoList;
    }

    public String getCaVerifyFileUrl() {
        return caVerifyFileUrl;
    }

    public void setCaVerifyFileUrl(String caVerifyFileUrl) {
        this.caVerifyFileUrl = caVerifyFileUrl;
    }
}
