package com.minigod.protocol.account.vo.response;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserInfoResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String phone;
    private String email;
}
