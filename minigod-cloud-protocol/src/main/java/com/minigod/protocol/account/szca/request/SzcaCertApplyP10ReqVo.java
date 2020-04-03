package com.minigod.protocol.account.szca.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaCertApplyP10ReqVo implements Serializable {
    private static final long serialVersionUID = 4244259249337864190L;

    private String token;
    private String userName;
    private String idNo;
    private String sex;
    private String mobileNo;
    private String identityImgOne;
    private String identityImgTwo;
    private String identityImgHead;
    private String humanBodyImg;
    private String signImg;
    private String identityImgHold;
    private String province;
    private String city;
    private String contactAddr;
    private String cardedPlace;
    private String cardedExpiryDate;
    private String card;
    private String carrier;
    private String certDn;
    private String certP10;
    private String appType;
}
