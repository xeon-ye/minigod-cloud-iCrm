package com.minigod.api.grm.t2sdk.vo.resp;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 */
public class EF01110127VO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String opRemark;
    private String remark;

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
