package com.minigod.api.grm.ds.req;

import com.minigod.api.grm.GrmRequestVO;
import com.minigod.api.quotmonitor.vo.enums.EMarket;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 根据月份获取交易日历
 */
public class EF0501004Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
