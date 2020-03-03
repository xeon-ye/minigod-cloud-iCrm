package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 取客户帐号列表
 */
public class EF01110014Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;
    private String branchNo;
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
