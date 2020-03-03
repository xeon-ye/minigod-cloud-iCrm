package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 查询股票流水
 */
public class EF01100839Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fundAccount;

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

}
