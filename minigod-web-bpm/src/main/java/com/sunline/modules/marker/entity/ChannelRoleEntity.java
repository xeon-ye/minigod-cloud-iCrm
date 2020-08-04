package com.sunline.modules.marker.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 渠道角色关联表
 *
 * @author lcs
 * @email
 * @date 2018-12-04 15:19:00
 */
public class ChannelRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleId;
    private String channelId;
    private String createTime;
    private String createUser;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
