package com.minigod.api.grm.t2sdk.vo.req;

import com.minigod.api.grm.GrmRequestVO;

import java.io.Serializable;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 资金解冻
 */
public class EF01110007Request extends GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jourDate;
    private String jourSerialNo;
    private String cancelBalance;
    private String occurBalance;

    public String getJourDate() {
        return jourDate;
    }

    public void setJourDate(String jourDate) {
        this.jourDate = jourDate;
    }

    public String getJourSerialNo() {
        return jourSerialNo;
    }

    public void setJourSerialNo(String jourSerialNo) {
        this.jourSerialNo = jourSerialNo;
    }

    public String getCancelBalance() {
        return cancelBalance;
    }

    public void setCancelBalance(String cancelBalance) {
        this.cancelBalance = cancelBalance;
    }

    public String getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(String occurBalance) {
        this.occurBalance = occurBalance;
    }
}
