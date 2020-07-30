package com.minigod.protocol.account.szca.jfrequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class JFSzcaLoginReqVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPwd;
}
