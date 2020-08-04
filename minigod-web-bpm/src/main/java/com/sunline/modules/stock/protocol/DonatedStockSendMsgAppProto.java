package com.sunline.modules.stock.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 领取拒绝 推送消息app
 */
public class DonatedStockSendMsgAppProto {

    /**
     *  用户id列表
     */
    @JSONField(name = "lstToUserId")
    private Object lstToUserId;

    /**
     *  领取被拒绝：1102
     */
    @JSONField(name = "templateCode")
    private Integer templateCode;

    /**
     *  一级分类    服务通知：12007
     */
    @JSONField(name = "displayGroup")
    private Integer displayGroup;

    /**
     *  二级分类    服务弱通知：1902
     */
    @JSONField(name = "msgCode")
    private Integer msgCode;

    /**
     *  ["姓名"]
     */
    @JSONField(name = "params")
    private Object params;

    public Object getLstToUserId() {
        return lstToUserId;
    }

    public void setLstToUserId(Object lstToUserId) {
        this.lstToUserId = lstToUserId;
    }

    public Integer getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(Integer templateCode) {
        this.templateCode = templateCode;
    }

    public Integer getDisplayGroup() {
        return displayGroup;
    }

    public void setDisplayGroup(Integer displayGroup) {
        this.displayGroup = displayGroup;
    }

    public Integer getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
