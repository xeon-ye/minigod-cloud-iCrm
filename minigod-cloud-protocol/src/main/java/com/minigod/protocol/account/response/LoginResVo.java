package com.minigod.protocol.account.response;

import lombok.Data;

import java.io.Serializable;


@Data
public class LoginResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
}
