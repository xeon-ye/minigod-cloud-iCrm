package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * Created by huhu on 2016/7/11.
 */
public class StkMoneyFlowReqVO extends SNVersion {

    private StkMoneyFlowVO params;

    public StkMoneyFlowVO getParams() {
        return params;
    }

    public void setParams(StkMoneyFlowVO params) {
        this.params = params;
    }
}
