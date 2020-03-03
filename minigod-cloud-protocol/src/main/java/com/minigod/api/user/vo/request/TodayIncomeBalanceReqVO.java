package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.open.req.FundStockInfoReqVO;

/**
 * @description:
 * @author: Larry Lai
 * @date: 2017/12/5 0005 下午 4:15
 * @version: v1.0
 */

public class TodayIncomeBalanceReqVO extends SNVersion {
    private static final long serialVersionUID = 1L;

    private FundStockInfoReqVO params;

    private String requestSrc;//请求来源：ios，Android，H5

    public FundStockInfoReqVO getParams() {
        return params;
    }

    public void setParams(FundStockInfoReqVO params) {
        this.params = params;
    }

    public String getRequestSrc() {
        return requestSrc;
    }

    public void setRequestSrc(String requestSrc) {
        this.requestSrc = requestSrc;
    }
}
