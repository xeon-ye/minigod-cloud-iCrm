package com.minigod.api.grm.t2sdk.vo.resp;

import com.minigod.api.grm.t2sdk.vo.ClientInfo;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 根据客户号查当前默认帐号资产返回对象
 */
public class EF01281001VO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ClientInfo clientInfo;


    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

}
