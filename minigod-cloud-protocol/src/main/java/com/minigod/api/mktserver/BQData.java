package com.minigod.api.mktserver;

import com.minigod.api.mktserver.BC.BCQconInfo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CaiJianbo on 2016/5/13 18:09.
 * minigod
 */
public class BQData implements Serializable{
    private String assetId;
    private static final long serialVersionUID = 1L;

    private BCQconInfo[] buyQueue;

    private BCQconInfo[] sellQueue;

    private Date buyUpdateTime ;
    private Date sellUpdateTime;

    public BCQconInfo[] getBuyQueue() {
        return buyQueue;
    }

    public void setBuyQueue(BCQconInfo[] buyQueue) {
        this.buyQueue = buyQueue;
    }

    public BCQconInfo[] getSellQueue() {
        return sellQueue;
    }

    public void setSellQueue(BCQconInfo[] sellQueue) {
        this.sellQueue = sellQueue;
    }

    public Date getBuyUpdateTime() {
        return buyUpdateTime;
    }

    public void setBuyUpdateTime(Date buyUpdateTime) {
        this.buyUpdateTime = buyUpdateTime;
    }

    public Date getSellUpdateTime() {
        return sellUpdateTime;
    }

    public void setSellUpdateTime(Date sellUpdateTime) {
        this.sellUpdateTime = sellUpdateTime;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
