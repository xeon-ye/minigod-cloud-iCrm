package com.minigod.api.user.vo.open.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/4/1 20:44
 */
public class OpenUserInfoReqVO extends SNVersion {
    private static final long serialVersionUID = 1L;
    private OpenUserInfoVO params;

    public OpenUserInfoVO getParams() {
        return params;
    }

    public void setParams(OpenUserInfoVO params) {
        this.params = params;
    }
}
