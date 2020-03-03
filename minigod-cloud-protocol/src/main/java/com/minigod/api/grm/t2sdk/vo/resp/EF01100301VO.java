package com.minigod.api.grm.t2sdk.vo.resp;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 取最大可买卖股票数量
 */
public class EF01100301VO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String enableAmount;

    public String getEnableAmount() {
        return enableAmount;
    }

    public void setEnableAmount(String enableAmount) {
        this.enableAmount = enableAmount;
    }
}
