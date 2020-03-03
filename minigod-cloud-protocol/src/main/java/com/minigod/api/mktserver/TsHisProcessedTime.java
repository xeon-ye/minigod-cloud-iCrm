package com.minigod.api.mktserver;


import com.minigod.api.mktserver.RtTime;

import java.util.List;

/**
 * <code>ShRtTime</code>
 *
 * @author Jimmy
 * @version v1.0
 * @date 2015-7-3 下午4:02:32
 */
public class TsHisProcessedTime extends RtTime {
    private static final long serialVersionUID = 1L;
    private String marketCode;
    private List<String> processedTimes;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public List<String> getProcessedTimes() {
        return processedTimes;
    }

    public void setProcessedTimes(List<String> processedTimes) {
        this.processedTimes = processedTimes;
    }
}
