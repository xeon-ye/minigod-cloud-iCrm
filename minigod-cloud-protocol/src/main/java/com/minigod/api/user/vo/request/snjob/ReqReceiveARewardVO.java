package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author chenyouhuo
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/11/17 14:53
 */
public class ReqReceiveARewardVO extends SNVersion {
    private static final long serialVersionUID = -4477804668376707937L;
    private ReqReceiveAReward params;

    public ReqReceiveAReward getParams() {
        return params;
    }

    public void setParams(ReqReceiveAReward params) {
        this.params = params;
    }
}
