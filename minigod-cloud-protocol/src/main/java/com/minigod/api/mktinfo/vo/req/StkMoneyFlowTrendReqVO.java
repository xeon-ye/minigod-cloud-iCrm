package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * Created by huhu on 2016/7/11.
 */
public class StkMoneyFlowTrendReqVO extends SNVersion {

    private StkMoneyFlowTrendVO params;

    public StkMoneyFlowTrendVO getParams() {
        return params;
    }

    public void setParams(StkMoneyFlowTrendVO params) {
        this.params = params;
    }
}
