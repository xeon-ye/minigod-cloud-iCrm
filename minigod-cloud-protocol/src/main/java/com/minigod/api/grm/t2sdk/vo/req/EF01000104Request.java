package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 所属营业部查询请求对象
 */
public class EF01000104Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String opStation;
    private String clientId;

    public String getOpStation() {
        return opStation;
    }

    public void setOpStation(String opStation) {
        this.opStation = opStation;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

}
