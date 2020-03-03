package com.minigod.api.grm.t2sdk.vo.resp;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 查找股票
 */
public class EF01100302VO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String entrustNo;

    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo;
    }
}
