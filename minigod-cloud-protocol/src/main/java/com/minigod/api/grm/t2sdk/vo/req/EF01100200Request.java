package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 交易登录请求对象
 */
public class EF01100200Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String branchNo;
    private String opStation;
    private String entrustWay;
    private String clientId;
    private String password;

    public String getOpStation() {
        return opStation;
    }

    public void setOpStation(String opStation) {
        this.opStation = opStation;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getEntrustWay() {
        return entrustWay;
    }

    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }
}
