package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * AE/操作员退出
 */
public class EF01110019Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String opPassword;

    public String getOpPassword() {
        return opPassword;
    }

    public void setOpPassword(String opPassword) {
        this.opPassword = opPassword;
    }
}
