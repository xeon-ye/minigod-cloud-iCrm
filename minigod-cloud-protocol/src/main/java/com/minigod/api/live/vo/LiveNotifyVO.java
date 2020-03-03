package com.minigod.api.live.vo;

import com.minigod.common.anno.TransferBean;

import java.io.Serializable;

/**
 * Created by huhu on 2016/8/29.
 */
@TransferBean
public class LiveNotifyVO  implements Serializable  {
    private static final long serialVersionUID = -2260388125919493487L;
    private String vid;
    private String action;
    private String reason;
    private String duration;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
