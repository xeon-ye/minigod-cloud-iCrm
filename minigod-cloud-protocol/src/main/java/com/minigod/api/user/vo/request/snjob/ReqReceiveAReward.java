package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @author chenyouhuo
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/11/11 14:54
 */
public class ReqReceiveAReward extends SNUserBase {
    private Integer userProgressId;

    public Integer getUserProgressId() {
        return userProgressId;
    }

    public void setUserProgressId(Integer userProgressId) {
        this.userProgressId = userProgressId;
    }
}
