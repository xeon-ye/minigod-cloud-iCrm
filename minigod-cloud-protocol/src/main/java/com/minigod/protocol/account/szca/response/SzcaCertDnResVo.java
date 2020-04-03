package com.minigod.protocol.account.szca.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaCertDnResVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String retCode;
    private String descInfo;

    private String certDN;
    private String certSn;
    private String state;
}
