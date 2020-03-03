package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;
import com.minigod.api.grm.utils.FareKindStr;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 交易费用设置
 */
public class EF01110126Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clientId;
    private String fundAccount;
    private FareKindStr fareKindStr;



    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public FareKindStr getFareKindStr() {
        return fareKindStr;
    }

    public void setFareKindStr(FareKindStr fareKindStr) {
        this.fareKindStr = fareKindStr;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
