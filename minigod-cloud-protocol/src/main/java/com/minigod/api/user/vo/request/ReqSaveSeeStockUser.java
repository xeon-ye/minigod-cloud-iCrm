/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Description
 * @Author kouyandong
 * @Date 2016/5/12
 * @Version v1.0
 */
public class ReqSaveSeeStockUser extends SNUserBase {

    private static final long serialVersionUID = -2615511581281471459L;
    private String assetId;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
