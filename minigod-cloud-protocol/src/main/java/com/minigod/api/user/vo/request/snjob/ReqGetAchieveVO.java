package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/7/21 14:53
 */
public class ReqGetAchieveVO extends SNVersion {

    private static final long serialVersionUID = 5515292702464663976L;
    private ReqGetAchieve params;

    public ReqGetAchieve getParams() {
        return params;
    }

    public void setParams(ReqGetAchieve params) {
        this.params = params;
    }
}
