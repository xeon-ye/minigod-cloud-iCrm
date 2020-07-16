package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 用户登录请求协议
 * @author: Larry Lai
 * @date: 2019/7/19 10:00
 * @version: v1.0
 */

public class UserLoginRequest {

    /**
     * 菜单项标识（传空）
     */
    @JSONField(name = "menu_id")
    private Integer menuID;

    /**
     * 操作员密码	 必填
     */
    @JSONField(name = "op_password")
    private String opPassword;

    /**
     * 复核类型（1）必填
     */
    @JSONField(name = "audit_action")
    private String auditAction;

    /**
     * 输入字符（1）必填
     */
    @JSONField(name = "action_in")
    private Integer actionIn;

    /**
     * 计算机名 必填
     */
    @JSONField(name = "host_name")
    private String hostName;

    /**
     *  IP地址	必填
     */
    @JSONField(name = "ip_addr")
    private String ipAddr;

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public String getOpPassword() {
        return opPassword;
    }

    public void setOpPassword(String opPassword) {
        this.opPassword = opPassword;
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction;
    }

    public Integer getActionIn() {
        return actionIn;
    }

    public void setActionIn(Integer actionIn) {
        this.actionIn = actionIn;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
