package com.minigod.api.mktserver;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/5/14 13:24.
 * 分笔结构
 * minigod
 */
public class TickData implements Serializable{
    private static final long serialVersionUID = -1551958913919371631L;
    private String assetId;
    //成交时间；
    private String time;
    //成交量
    private Double volume;
    //内外盘方向
    private String plateFlag;
    //经纪人编号
    private String brokerNo;
    //成交均价
    private Double price;
    //撮合方式
    private String tradeType;
    private long ts;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlateFlag() {
        return plateFlag;
    }

    public void setPlateFlag(String plateFlag) {
        this.plateFlag = plateFlag;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getBrokerNo() {
        return brokerNo;
    }

    public void setBrokerNo(String brokerNo) {
        this.brokerNo = brokerNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
