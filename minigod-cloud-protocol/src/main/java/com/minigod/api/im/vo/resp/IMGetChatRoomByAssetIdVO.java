package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * Created by ChenYouhuo on 2016/6/22.
 */
public class IMGetChatRoomByAssetIdVO implements Serializable {
    private static final long serialVersionUID = 464474682389426034L;
    private String groupId;//聊天室ID
    private String groupName; // 聊天室的名称
    private String icon; // 聊天室头像
    private Integer memberCount; // 聊天室人数

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }
}
