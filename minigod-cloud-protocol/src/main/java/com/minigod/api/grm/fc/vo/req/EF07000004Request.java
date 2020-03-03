package com.minigod.api.grm.fc.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 获取行情产品列表
 */
public class EF07000004Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 犇犇号 **/
    private String yyId;
    private String clientId;



    public String getYyId() {
        return yyId;
    }

    public void setYyId(String yyId) {
        this.yyId = yyId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}
