package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/7/21 14:54
 */
public class ReqSignIn extends SNUserBase {
    private String taskType;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
