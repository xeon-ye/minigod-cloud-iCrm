package com.minigod.api.mktserver;

import java.io.Serializable;

/**
 * Created by huhu on 2016/7/11.
 */
public class TopChange implements Serializable {

    private String assetId;
    private Double changePct;
    private String time;
    private Double price;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Double getChangePct() {
        return changePct;
    }

    public void setChangePct(Double changePct) {
        this.changePct = changePct;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
