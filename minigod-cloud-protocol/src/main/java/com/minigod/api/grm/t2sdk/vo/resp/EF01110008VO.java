package com.minigod.api.grm.t2sdk.vo.resp;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 现金存
 */
public class EF01110008VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serialNo;
    private String tmpJoinSerialno;
    private String auditSerialNo;
    private String opRemark;
    private String feeJoinSerialno;

    public String getTmpJoinSerialno() {
        return tmpJoinSerialno;
    }

    public void setTmpJoinSerialno(String tmpJoinSerialno) {
        this.tmpJoinSerialno = tmpJoinSerialno;
    }

    public String getAuditSerialNo() {
        return auditSerialNo;
    }

    public void setAuditSerialNo(String auditSerialNo) {
        this.auditSerialNo = auditSerialNo;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    public String getFeeJoinSerialno() {
        return feeJoinSerialno;
    }

    public void setFeeJoinSerialno(String feeJoinSerialno) {
        this.feeJoinSerialno = feeJoinSerialno;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
