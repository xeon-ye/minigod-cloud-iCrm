package com.minigod.api.grm.fc.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 登录返回行情信息
 */
public class EF07000003VO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected boolean hkLive = false;

    /**
     * 港股川流行情有效期截止日期 YYYYmmdd
     */
    protected String hkEdate;

    protected String hkBdate;

    public boolean getHkLive() {
        return hkLive;
    }

    public void setHkLive(boolean hkLive) {
        this.hkLive = hkLive;
    }

    public String getHkEdate() {
        return hkEdate;
    }

    public void setHkEdate(String hkEdate) {
        this.hkEdate = hkEdate;
    }

    public String getHkBdate() {
        return hkBdate;
    }

    public void setHkBdate(String hkBdate) {
        this.hkBdate = hkBdate;
    }
}
