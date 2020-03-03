package com.minigod.security.protocol.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author PENGFENG
 * @createDate 2018-10-15
 * @description
 */
public class OpenAccountResultCallbackPojo implements Serializable {

    private static final long serialVersionUID = 2634294250832256177L;
    /**
     * 开户接入方式[1=H5开户 2=APP开户]
     */
    @JSONField(name = "openAccountAccessWay")
    private Integer openAccountAccessWay;

    /**
     * 开户回调状态[0-开户预批通过  3-基本资料错误(开户被退回，即全部资料打回)  4-影响资料错误(开户被退回，即只打回图片) 7-开户被拒绝 8-取消开户]
     */
    @JSONField(name = "openStatus")
    private Integer openStatus;

    @JSONField(name = "userId")
    private Integer userId;

    @JSONField(name = "clientId")
    private String clientId;

    @JSONField(name = "openDate")
    private String openDate;

    /**
     * 退回理由(文字描述)[8-电子签名不符合要求 9-财务信息有误 10-证照信息与填写内容不符 11-税务信息有误 12-银行帐户有误 13-身份资料披露不合格 14-职业信息有误 15-其他原因]
     */
    @JSONField(name = "errorInfo")
    private String errorInfo;

//    @JSONField(name = "errorImages")
//    private List<OpenAccountImageInfo> errorImages;

    @JSONField(name = "openAccountFileUrl")
    private String openAccountFileUrl;

    public Integer getOpenAccountAccessWay() {
        return openAccountAccessWay;
    }

    public void setOpenAccountAccessWay(Integer openAccountAccessWay) {
        this.openAccountAccessWay = openAccountAccessWay;
    }

    public Integer getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

//    public List<OpenAccountImageInfo> getErrorImages() {
//        return errorImages;
//    }
//
//    public void setErrorImages(List<OpenAccountImageInfo> errorImages) {
//        this.errorImages = errorImages;
//    }

    public String getOpenAccountFileUrl() {
        return openAccountFileUrl;
    }

    public void setOpenAccountFileUrl(String openAccountFileUrl) {
        this.openAccountFileUrl = openAccountFileUrl;
    }
}
