package com.minigod.api.mktserver;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <code>ShRtTime</code>
 *
 * @author Jimmy
 * @version v1.0
 * @date 2015-7-3 下午4:02:32
 */
public class TsHisPushedTime implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marketCode;
    private String time00;
    private Date pushTime;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getTime00() {
        return time00;
    }

    public void setTime00(String time00) {
        this.time00 = time00;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}
