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
public class ReqFindSnUserAchieveLog extends SNUserBase {
    private static final long serialVersionUID = 5842176715946712650L;
    private Integer count=20;
    private Integer achieveLogId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAchieveLogId() {
        return achieveLogId;
    }

    public void setAchieveLogId(Integer achieveLogId) {
        this.achieveLogId = achieveLogId;
    }
}
