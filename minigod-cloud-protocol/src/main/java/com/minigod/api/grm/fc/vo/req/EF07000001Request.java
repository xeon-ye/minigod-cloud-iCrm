package com.minigod.api.grm.fc.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 根据行情帐号【社区、交易等】获取行情产品信息
 */
public class EF07000001Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hqAccount;
    private String sysFlag;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    private String lang;


    public String getHqAccount() {
        return hqAccount;
    }

    public void setHqAccount(String hqAccount) {
        this.hqAccount = hqAccount;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    @Override
    public String toString() {
        return "EF07000001Request{" +
                "hqAccount='" + hqAccount + '\'' +
                ", sysFlag='" + sysFlag + '\'' +
                ", lang='" + lang + '\'' +
                "} " + super.toString();
    }
}
