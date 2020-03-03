/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

public class ReqGuessStockVO extends SNVersion {

    private static final long serialVersionUID = 5023371453514434609L;
    private ReqGuessStock params;

    public ReqGuessStock getParams() {
        return params;
    }

    public void setParams(ReqGuessStock params) {
        this.params = params;
    }
}
