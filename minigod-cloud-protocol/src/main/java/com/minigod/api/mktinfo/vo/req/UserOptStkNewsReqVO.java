package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * Created by ChenYouhuo on 2016/5/16.
 */
public class UserOptStkNewsReqVO extends SNVersion {
    private static final long serialVersionUID = -1825751102833647288L;
    private UserOptStkNewsVO params;

    public UserOptStkNewsVO getParams() {
        return params;
    }

    public void setParams(UserOptStkNewsVO params) {
        this.params = params;
    }
}
