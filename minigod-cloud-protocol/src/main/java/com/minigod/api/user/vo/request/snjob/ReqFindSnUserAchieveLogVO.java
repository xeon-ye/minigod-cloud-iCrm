package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @author chenyouhuo
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/11/11 14:53
 */
public class ReqFindSnUserAchieveLogVO extends SNUserBase {
    private static final long serialVersionUID = 899666999858634290L;
    private ReqFindSnUserAchieveLog params;

    public ReqFindSnUserAchieveLog getParams() {
        return params;
    }

    public void setParams(ReqFindSnUserAchieveLog params) {
        this.params = params;
    }
}
