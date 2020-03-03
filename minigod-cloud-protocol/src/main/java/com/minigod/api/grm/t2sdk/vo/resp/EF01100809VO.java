package com.minigod.api.grm.t2sdk.vo.resp;

import com.minigod.api.grm.t2sdk.vo.EntrustRecord;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 查当日委托明细
 */
public class EF01100809VO extends EntrustRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String assetId;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
