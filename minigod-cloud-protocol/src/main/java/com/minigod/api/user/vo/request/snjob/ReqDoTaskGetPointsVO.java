package com.minigod.api.user.vo.request.snjob;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author chenyouhuo
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/11/11 14:53
 */
public class ReqDoTaskGetPointsVO extends SNVersion {
    private static final long serialVersionUID = -8331222031124761281L;

    private ReqDoTaskGetPoints params;

    public ReqDoTaskGetPoints getParams() {
        return params;
    }

    public void setParams(ReqDoTaskGetPoints params) {
        this.params = params;
    }
}
