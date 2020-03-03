package com.minigod.api.grm.ds.req;

import com.minigod.api.grm.GrmRequestVO;
import com.minigod.api.quotmonitor.vo.enums.EMarket;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 获取单个市场的股票码表
 */
public class EF0501002Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private EMarket marketCode;

    public EMarket getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(EMarket marketCode) {
        this.marketCode = marketCode;
    }
}
