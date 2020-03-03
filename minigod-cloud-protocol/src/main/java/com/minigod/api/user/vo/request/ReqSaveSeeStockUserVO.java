/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * Created by ChenYouhuo on 2016/5/11.
 */
public class ReqSaveSeeStockUserVO extends SNVersion {

    private static final long serialVersionUID = 5023371453514434609L;
    private ReqSaveSeeStockUser params;

    public ReqSaveSeeStockUser getParams() {
        return params;
    }

    public void setParams(ReqSaveSeeStockUser params) {
        this.params = params;
    }
}
