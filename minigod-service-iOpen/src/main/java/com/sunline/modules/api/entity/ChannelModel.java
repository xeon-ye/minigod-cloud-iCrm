package com.sunline.modules.api.entity;


import java.io.Serializable;

/**
 * @author lcs
 * @date 2018-7-26
 */
public class ChannelModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道号
     */
    private String channelId;
    /**
     * 渠道名
     */
    private String channelName;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
