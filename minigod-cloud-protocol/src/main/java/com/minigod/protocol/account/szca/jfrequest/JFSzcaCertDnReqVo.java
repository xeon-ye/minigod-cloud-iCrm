package com.minigod.protocol.account.szca.jfrequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class JFSzcaCertDnReqVo implements Serializable {
    private static final long serialVersionUID = -839138200977553649L;
    private String utoken;

    private String token;
    private String idNo;
    private String userName;
    private String carrier = "0";
    private String type = "query";
}
