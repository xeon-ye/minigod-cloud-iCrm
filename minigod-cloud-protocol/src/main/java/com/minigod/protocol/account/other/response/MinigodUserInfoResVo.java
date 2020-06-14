package com.minigod.protocol.account.other.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class MinigodUserInfoResVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userCode;
    private String phoneNum;

}
