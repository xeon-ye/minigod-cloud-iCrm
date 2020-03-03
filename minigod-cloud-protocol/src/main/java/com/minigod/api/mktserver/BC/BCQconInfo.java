package com.minigod.api.mktserver.BC;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/5/11 20:23.
 * minigod
 */
public class BCQconInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 1 代表iStocker是价差
     * 0 代表iStocker是经纪编号
     */
    short flag;
    int iStocker;

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public int getiStocker() {
        return iStocker;
    }

    public void setiStocker(int iStocker) {
        this.iStocker = iStocker;
    }
}
