package com.minigod.protocol.account.szca.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaTokenReqVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgName;
    private String orgCode;
    private String tokenType;
    private String applyType;
}
