package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 客户集成登录
 */
public class EF01180200Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String opStation;
    private String clientId;
    private String password;

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

    public String getOpStation() {
        return opStation;
    }

    public void setOpStation(String opStation) {
        this.opStation = opStation;
    }

}
