package com.minigod.protocol.account.szca.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaCertApplyP10ResVo implements Serializable {
    private static final long serialVersionUID = 2411462776665863347L;

    private String retCode;
    private String descInfo;

    private String certDN;
    private String certSn ;
}
