package com.minigod.api.mktserver;

/**
 * Created by CaiJianbo on 2016/5/13 18:05.
 * minigod
 */
public class BrokerQueue {

    private static final long serialVersionUID = 1L;

    /**
     * brokerNo
     */
    int brokerNo;
    /**
     * spread
     */
    int spreadNo;

    public int getBrokerNo() {
        return brokerNo;
    }

    public void setBrokerNo(int brokerNo) {
        this.brokerNo = brokerNo;
    }

    public int getSpreadNo() {
        return spreadNo;
    }

    public void setSpreadNo(int spreadNo) {
        this.spreadNo = spreadNo;
    }
}
