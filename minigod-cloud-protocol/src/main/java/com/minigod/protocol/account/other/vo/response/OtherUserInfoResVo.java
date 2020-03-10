package com.minigod.protocol.account.other.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OtherUserInfoResVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isRealUser;
    private String phoneNumber;
    private String email;
    private String remarks;

}
