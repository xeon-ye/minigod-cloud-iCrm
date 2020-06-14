package com.minigod.protocol.account.other.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class OtherUserInfoResVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isRealUser;
    private Integer thirdCode;
    private String phoneNumber;
    private String email;
    private String remarks;
}
