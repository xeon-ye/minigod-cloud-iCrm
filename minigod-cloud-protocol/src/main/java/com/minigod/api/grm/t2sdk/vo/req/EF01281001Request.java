package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 根据客户号查当前默认帐号资产返回对象
 */
public class EF01281001Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;
    //客户端调用opStation
    private String opStation;
    //服务器自动填充
    private String entrustWay;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEntrustWay() {
        return entrustWay;
    }

    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }

    public String getOpStation() {
        return opStation;
    }

    public void setOpStation(String opStation) {
        this.opStation = opStation;
    }
}
