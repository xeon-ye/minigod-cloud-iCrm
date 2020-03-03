package com.minigod.api.grm.fc.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 根据行情帐号【社区、交易等】获取行情产品信息
 */
public class EF07000003Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 犇犇号 **/
    private String yyId;
    private String clientId;
    //赠送时长，单位自然月；
    private int bonusQty;
    //生效时间，默认当天
    private Date valueDate;
    private String sysFlag;
    private String remark;


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

    public int getBonusQty() {
        return bonusQty;
    }

    public void setBonusQty(int bonusQty) {
        this.bonusQty = bonusQty;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
