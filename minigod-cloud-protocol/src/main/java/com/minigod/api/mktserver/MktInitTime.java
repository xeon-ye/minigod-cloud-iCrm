package com.minigod.api.mktserver;


import com.minigod.api.mktinfo.vo.enums.EMarketStatus;

import java.io.Serializable;
import java.util.Date;

public class  MktInitTime implements Serializable{
    private static final long serialVersionUID = 1L;
    private String marketCode;
    private Date initTime;
    private String date;
    private String time;
    private String timeZoneId;
    private EMarketStatus marketStatus;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public EMarketStatus getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(EMarketStatus marketStatus) {
        this.marketStatus = marketStatus;
    }
}
