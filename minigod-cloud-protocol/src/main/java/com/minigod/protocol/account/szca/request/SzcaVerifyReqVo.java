package com.minigod.protocol.account.szca.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaVerifyReqVo implements Serializable {
    private static final long serialVersionUID = -839138200977553649L;

    private String token;
    private String idNo;
    private String userName;

}
