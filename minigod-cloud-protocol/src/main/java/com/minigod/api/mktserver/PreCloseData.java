package com.minigod.api.mktserver;


import org.apache.commons.collections.map.HashedMap;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <code>ShRtTime</code>
 *
 * @author Jimmy
 * @version v1.0
 * @date 2015-7-3 下午4:02:32
 */
public class PreCloseData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marketCode;
    private Map<String,Double> preClosedPrices = new HashedMap();
    private String updateTimeStr;
    private Date lastUpdateTime;
    private Date updateTime;

    public String getMarketCode() {
        return marketCode;
    }
    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public Map<String, Double> getPreClosedPrices() {
        return preClosedPrices;
    }

    public void setPreClosedPrices(Map<String, Double> preClosedPrices) {
        this.preClosedPrices = preClosedPrices;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
