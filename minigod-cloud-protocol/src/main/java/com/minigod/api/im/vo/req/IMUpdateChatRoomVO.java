package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * Created by ChenYouhuo on 2016/4/28.
 */
public class IMUpdateChatRoomVO extends BaseVO {
    private static final long serialVersionUID = -7851608193409243102L;
    private String id;
    private String name;
    private String description;
    private Integer maxUsers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }
}
