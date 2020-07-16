package com.sunline.modules.quotation.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 股票行情服务协议
 * @author: Larry Lai
 * @date: 2019/2/22 16:33
 * @version: v1.0
 */

public class StockQuotRequest {

    /**
     * 股票代码
     */
    @JSONField(name = "assetId")
    private String assetId;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
